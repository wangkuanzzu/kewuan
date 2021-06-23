package com.wink.learn.designpattern.decorate.jdk;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * description: TestMain <br>
 * date: 2021/5/31 下午3:56 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    public static void main(String[] args) throws IOException {

        InputStream myInputStream = new MyInputStream(new BufferedInputStream(new FileInputStream("/Users/kuan/IdeaProjects/kewuan/src/main/java/designpattern/decorate/jdk/test.txt")));
//        byte[] arr = new byte[16];
//        int len;
//        while ((len = myInputStream.read(arr)) != -1) {
//            System.out.println(new String(arr, 0, len));
//        }

        int c;
        while ((c = myInputStream.read()) >= 0) {
            System.out.print((char) c);
        }
        myInputStream.close();

    }
}
