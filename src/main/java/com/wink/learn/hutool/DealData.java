package com.wink.learn.hutool;

import cn.hutool.core.io.file.FileReader;

import java.io.FileWriter;
import java.io.IOException;

/**
 * description: DealData <br>
 * date: 2021/6/30 上午9:20 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class DealData {

    public static void main(String[] args) throws IOException {

        String fileName = "/Users/kuan/temp/yangchihang/yangchihang-result.txt";
        FileReader fileReader = new FileReader(fileName);
        String current = "";
        String last = "";
        FileWriter writer = new FileWriter("/Users/kuan/temp/yangchihang/yangchihang-result-1.txt");
        for (String readLine : fileReader.readLines()) {
            current = readLine;
            writer.write(current.replace(last, "")+"\n");
            last = readLine;
        }
        writer.close();


    }
}
