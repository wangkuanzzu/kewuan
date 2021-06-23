package com.wink.learn.a;

import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * description: com.wink.learn.a.DealClick <br>
 * date: 2020/9/28 10:43 上午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class DealOpen {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/kuan/temp/1.log";
        FileReader fileReader = new FileReader(fileName);
        if(fileReader == null){
            return;
        }
        Long assetId,adId,parkingId,trafficId,adsenseId,adsensePositionId;
        String createTime,hour;
        StringBuilder stringBuilder = new StringBuilder();
        FileWriter writer = new FileWriter("1.sql");
        for (String s:fileReader.readLines()) {
            String str = s.substring(s.indexOf("logInfo")+9,s.indexOf("publicKey")-2);
            createTime = s.substring(1,s.indexOf("[INFO]")-5);
            hour = createTime.substring(11,13);
            JSONObject jsonObject = JSON.parseObject(str);
            adId = jsonObject.getLong("adId");
            assetId = jsonObject.getLong("assetId");
            parkingId = jsonObject.getLong("parkingId");
            trafficId = jsonObject.getLong("trafficId");
            adsenseId = jsonObject.getLong("adsenseId");
            adsensePositionId = jsonObject.getLong("adsensePositionId");

            String sql = "insert into ad_open_log (ad_id,parking_id,traffic_id,adsense_id,adsense_position_id,asset_id,create_hour,create_time) value (%s,%s,%s,%s,%s,%s,%s,%s);\n";
//            System.out.println(String.format(sql,adId,parkingId,trafficId,adsenseId,adsensePositionId,assetId,hour,"'"+createTime+"'"));

            writer.write(String.format(sql,adId,parkingId,trafficId,adsenseId,adsensePositionId,assetId,hour,"'"+createTime+"'"));
            writer.close();

        }
    }


}
