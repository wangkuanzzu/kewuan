package designpattern.template.jdk;

import java.util.Arrays;
import java.util.Collections;

/**
 * description: TestMain <br>
 * date: 2021/6/8 下午2:13 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {


    public static void main(String[] args) {
        Sheep[] sheeps = new Sheep[5];
        sheeps[0] = new Sheep("a",1);
        sheeps[1] = new Sheep("b",3);
        sheeps[2] = new Sheep("c",5);
        sheeps[3] = new Sheep("d",2);
        sheeps[4] = new Sheep("e",4);

        System.out.println(Arrays.toString(sheeps));
        Arrays.sort(sheeps);
        System.out.println(Arrays.toString(sheeps));
    }

}
