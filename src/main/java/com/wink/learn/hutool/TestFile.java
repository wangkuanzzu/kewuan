package com.wink.learn.hutool;

import java.io.*;

/**
 * description: TestFile <br>
 * date: 2020/10/18 12:23 下午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestFile {

        public static void main(String args[]) throws IOException {
            long t1 = System.currentTimeMillis();
            fun3();
            long t2 = System.currentTimeMillis();
            System.out.println(t2-t1);
        }

    //一个字节一个字节的复制，耗时22697毫秒
    public static void fun() throws IOException {
        FileInputStream fis = new FileInputStream("源文件");
        FileOutputStream fos = new FileOutputStream("新文件");
        int by = 0;
        while ((by=fis.read()) != -1) {
            fos.write(by);
        }
        fis.close();
        fos.close();
    }
    //1024字节数组复制 耗时63毫秒
    public static void fun1() throws IOException {
        FileInputStream fis = new FileInputStream("源文件");
        FileOutputStream fos = new FileOutputStream("新文件");
        int len = 0;
        byte[] bytes =new byte[1024];
        while ((len=fis.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
    }
    // 一个字节一个字节复制，但是用了缓冲流 耗时64毫秒
    public static void fun2() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("源文件"));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("新文件"));
        int by = 0;
        while ((by=bis.read()) != -1) {
            bos.write(by);
        }
        bis.close();
        bos.close();
    }
    // 1024字节数组复制并用了缓冲流 耗时7毫秒
    public static void fun3() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("源文件"));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("新文件"));
        int len = 0;
        byte[] bytes =new byte[1024];
        while ((len=bis.read(bytes)) != -1) {
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
    }
}
