package com.wink.learn.hutool;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.net.HttpCookie;

/**
 * description: ConvertDemo <br>
 * date: 2020/10/15 11:29 上午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ConvertDemo {

    public static void main(String[] args) throws Exception {

        String fileName = "/Users/kuan/temp/yangchihang/yangchihang.txt";
        FileReader fileReader = new FileReader(fileName, CharsetUtil.UTF_8);
        String url = null;
        String zanwu = "暂无";
        String fou = "否";
        String erjigongsi = "二级公司";
        String biggudong="中国宝武钢铁集团有限公司";
        FileWriter writer = new FileWriter("/Users/kuan/temp/yangchihang/yangchihang-result.txt");
        writer.write("公司名称  企查查地址   官网  注册资本    注册地址    第一股东    第二股东    二级公司\n");
        int i = 305;
        for (String s:fileReader.readLines()) {
            StringBuilder stringBuilder = new StringBuilder();
            String cName = s.substring(3).trim();
            String searchUrl = "https://www.qcc.com/web/search?key="+cName;
            HttpRequest get = HttpUtil.createGet(searchUrl);
            HttpResponse result2 = get.cookie(new HttpCookie("acw_tc","3ad7921e16249443825748236e4a1fbfaa29509c9f5597a5d848cd1fb8"))
                    .cookie(new HttpCookie("QCCSESSID","6a6c2f6776b41bcb6982321f24")).execute();
            String html= result2.body();

            Document doc = Jsoup.parse(html);
            Elements maininfo = doc.getElementsByClass("maininfo");
            if (maininfo.get(0).child(0) != null) {
                url = maininfo.get(0).child(0).attr("href");
                if(url.contains("firm")){
                    url = url.replace("firm","cbase");
                }
            }
            if (url != null) {
                String detailResult = HttpUtil.get(url);
                Document detailHtml = Jsoup.parse(detailResult);
                try{
                    Elements val = detailHtml.getElementsByClass("contact-info").get(0).child(1).getElementsByClass("val");
                    String guanwang = val.get(1).text();
                    String ziben = detailHtml.getElementsByClass("ntable").get(0).child(0).child(2).child(1).text();
                    String dizhi = detailHtml.getElementsByClass("ntable").get(0).child(0).child(8).child(1).child(0).text();

                    Element partner = detailHtml.getElementById("partner").getElementsByClass("tablist").get(0).getElementsByClass("app-ntable").get(0).getElementsByClass("ntable").get(0);
//                    System.out.println(partner);
                    Element child1 = partner.child(0).child(1);
                    String diyigudong = child1.getElementsByClass("name").get(0).child(0).text();
                    String diergudong = zanwu;
                    if (partner.child(0).children().size() > 2) {
                        Element child2 = partner.child(0).child(2);
                        diergudong = child2.getElementsByClass("name").get(0).child(0).text();
                    }
                    String shifou = fou;
                    if (diyigudong.equals(biggudong)) {
                        shifou = erjigongsi;
                    }

                    stringBuilder.append(cName).append("   ").append(url)
                            .append("   ").append(guanwang)
                            .append("    ").append(ziben)
                            .append("    ").append(dizhi)
                            .append("    ").append(diyigudong)
                            .append("    ").append(diergudong)
                            .append("    ").append(shifou);
                    writer.write(stringBuilder.toString());
                }catch (Exception e){
                    e.printStackTrace();
                    writer.write(cName + "----no data");
                }
            }else{
                writer.write(cName + "----no data");
            }
            writer.write("\n");
            i++;
            System.out.println("==已完成==" + i);
                Thread.sleep(1000*60);
        }
        writer.close();


//        System.out.println(DateUtil.now());
//        System.out.println(DateTime.now().toString(DatePattern.PURE_DATETIME_MS_PATTERN));


//        Object[] a = { "a", "你", "好", "", 1 , true};
//        List<String> list = Convert.convert(new TypeReference<List<String>>() {}, a);
//        System.out.println(list);

//        Object[] o={"a",1,"b",true};
//        List<?> list = Convert.toList(o);
//        System.out.println(list);


//        System.out.println(Convert.toDate("2020/09/30"));
//        System.out.println(Convert.toDate("2020-09-30"));
//        System.out.println(Convert.toDate("2020-9-30"));
//        System.out.println(Convert.toDate("20200930"));

//        int a = 1;
//        //aStr为"1"
//        String aStr = Convert.toStr(a);
//        System.out.println(aStr);
//
//        long[] b = {1,2,3,4,5};
//        //bStr为："[1, 2, 3, 4, 5]"
//        String bStr = Convert.toStr(b);
//        System.out.println(bStr);
//
//        String[] c = { "1", "2", "3", "4" };
//        //结果为Integer数组
//        Integer[] intArray = Convert.toIntArray(c);
//        System.out.println(intArray[1]);
//
//        long[] d = {1,2,3,4,5};
//        //结果为Integer数组
//        Integer[] intArray2 = Convert.toIntArray(d);
//        System.out.println(intArray2[2]);


    }
}
