package com.wink.learn.hello;

import cn.hutool.core.io.file.FileReader;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: CompareParkId <br>
 * date: 2021/7/19 下午3:29 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class CompareParkId {

    public static void main(String[] args) throws Exception {

        FileReader fileC = new FileReader("/Users/kuan/temp/c.txt");
        FileReader fileU = new FileReader("/Users/kuan/temp/u.txt");

        String[] splitC = fileC.readString().split(",");
        String[] splitU = fileU.readString().split(",");

        List<String> listU = Arrays.asList(splitU);
        List<String> listC = Arrays.asList(splitC);

        ArrayList<String> strings = new ArrayList<>();
        listU.forEach(item ->{
            if(!listC.contains(item)){
                strings.add(item);
            }
        });

        String s = "29841|29842|29848|29851|29855|29858|29860|29863|29869|29874|29875|29877";
        List<String> list = Splitter.on("|").omitEmptyStrings().splitToList(s);
        System.out.println(list);

        list.forEach(ob -> {
            System.out.println(ob);
            System.out.println(strings.contains(ob));
        });

        System.out.println(strings.size());


    }
}
