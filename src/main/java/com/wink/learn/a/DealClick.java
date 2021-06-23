package com.wink.learn.a;

import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * description: com.wink.learn.a.DealClick <br>
 * date: 2020/9/28 10:43 上午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class DealClick {

    public static void main(String[] args) {
        String fileName = "/Users/kuan/temp/20200928点击量修复/temp2.txt";
        FileReader fileReader = new FileReader(fileName);
        if(fileReader == null){
            return;
        }
        Long endUserId,adId,parkingId,trafficId,adsenseId,adsensePositionId;
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:fileReader.readLines()) {
            String str = s.substring(s.indexOf("logInfo")+9,s.indexOf("publicKey")-2);
            JSONObject jsonObject = JSON.parseObject(str);
            endUserId = jsonObject.getLong("endUserId");
            adId = jsonObject.getLong("adId");
            parkingId = jsonObject.getLong("parkingId");
            trafficId = jsonObject.getLong("trafficId");
            adsenseId = jsonObject.getLong("adsenseId");
            adsensePositionId = jsonObject.getLong("adsensePositionId");
            String sql = "insert into ad_click_log (ad_id,enduser_id,parking_id,traffic_id,adsense_id,adsense_position_id) value (%s,%s,%s,%s,%s,%s)";
            System.out.println(String.format(sql,adId,endUserId,parkingId,trafficId,adsenseId,adsensePositionId));
        }
    }


}
