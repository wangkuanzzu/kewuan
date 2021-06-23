package com.wink.learn.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;

public class HttpDemo {

    public static void main(String[] args) {

    }

    public static void testHttpUtil(){
        String url = "https://www.baidu.com";
        String result1 = HttpUtil.get(url);
        // 指定编码类型
        String result2 = HttpUtil.get(url, CharsetUtil.CHARSET_UTF_8);

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("name","wangkuan");
        // 参数会拼接至url后
        String result3 = HttpUtil.get(url, hashMap);

        // 参数默认到form中进行提交
        String result4 = HttpUtil.post(url,hashMap);

        HashMap<String,Object> paramMap = new HashMap<>();
        //文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
        paramMap.put("file", FileUtil.file("/Users/kuan/temp/1.text"));
        HttpUtil.post(url,paramMap);


        String fileUrl = "http://mirrors.aliyun.com/centos/8.1.1911/isos/x86_64/CentOS-8.1.1911-x86_64-dvd1.iso";

        //将文件下载后保存，返回结果为下载文件大小
        long size = HttpUtil.downloadFile(fileUrl, FileUtil.file("/Users/kuan/temp/"));
        System.out.println("Download size: " + size);

        // 监测下载进度
        HttpUtil.downloadFile(fileUrl, FileUtil.file("/Users/kuan/temp/"), new StreamProgress() {
            @Override
            public void start() {
                Console.log("下载开始。。。");
            }

            @Override
            public void progress(long l) {
                Console.log("已下载{}", FileUtil.readableFileSize(l));
            }

            @Override
            public void finish() {
                Console.log("下载结束。。。");
            }
        });

    }
}
