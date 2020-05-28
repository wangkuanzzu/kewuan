import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:测试短信报告的处理逻辑
 * <p>
 * Created By kuan on 2020/1/14
 */
public class TestGetSmsgReceive {
    public static void main(String[] args) {
        String result = "280329$$$$$18511342264$$$$$2020-01-13 16:06:16$$$$$1$$$$$DELIVRD$$$$$2020-01-13 16:06:23|||" +
                "280329$$$$$13439945751$$$$$2020-01-13 16:06:16$$$$$1$$$$$DELIVRD$$$$$2020-01-13 16:06:31|||";

        String[] xyxxStr = result.split("\\|\\|\\|");
        System.out.println(xyxxStr.length);

        for (int i = 0; i < xyxxStr.length; i++) {
            String[] resultArray = xyxxStr[i].split("\\$\\$\\$\\$\\$");
            if (xyxxStr.length == 1) {
                if (resultArray.length != 6) {
                    System.out.println("result length ==1 format error");
                }
            } else {
                if (resultArray.length != 6) {
                    System.out.println("多条状态中某一条格式存在错误"+ xyxxStr[i]);
                    continue;
                }
            }
            Map<String, String> logValue = new HashMap<String, String>();
            String id = resultArray[0];
            String mobile = resultArray[1];
            String time = resultArray[2];
            String reportFlag = resultArray[3];
            String report = resultArray[4];
            String reportTime = resultArray[5];

            //批次号
            logValue.put("msgId", id);
            logValue.put("mobile", mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
            logValue.put("time", time);
            logValue.put("reportFlag", reportFlag);
            logValue.put("report", report);
            logValue.put("reportTime", reportTime);



            //280329$$$$$18511342264$$$$$2020-01-13 16:06:16$$$$$1$$$$$DELIVRD$$$$$2020-01-13 16:06:23|||
            //280329$$$$$13439945751$$$$$2020-01-13 16:06:16$$$$$1$$$$$DELIVRD$$$$$2020-01-13 16:06:31|||
            // 处理状态请求
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                Date recvDate = format.parse(reportTime);
                format.applyPattern("yyyy-MM-dd HH:mm:ss");
                reportTime = format.format(recvDate);
            } catch (ParseException e) {
                logValue.put("ParseException", "parse(recvTime) error");
                System.out.println("date error for os" + logValue);
                continue;
            }

            // 组装mq消息
            String status = report;
            String reportMQ = String.format("%s,%s,%s,%s", id, mobile, status, reportTime);
            String reportLog = String.format("%s,%s,%s,%s",
                    id, mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"), status, reportTime);
            logValue.put("report", reportLog);
            try {
                System.out.println("A025 " + reportMQ);
            } catch (Exception e) {
                logValue.put("Exception", " rabbitTemplate.convertAndSend statusQueue error");
                System.out.println("rebbit error"+ logValue);
                continue;
            }
            System.out.println("single result"+ logValue);
        }
    }
}
