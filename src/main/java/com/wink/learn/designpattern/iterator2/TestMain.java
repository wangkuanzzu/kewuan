package com.wink.learn.designpattern.iterator2;

/**
 * description: TestMain <br>
 * date: 2021/6/25 下午1:44 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {


    public static void main(String[] args) {

        MenuComponent menu1 = new Menu("menu1","zaofan");
        MenuComponent menu2 = new Menu("menu2", "wufan");
        MenuComponent menu3 = new Menu("menu3", "wanfan");
        MenuComponent menu4 = new Menu("menu4", "yexiao");

        MenuComponent allMenu = new Menu("all menu", "suoyoufan");
        allMenu.add(menu1);
        allMenu.add(menu2);
        allMenu.add(menu3);

        menu1.add(new MenuItem("egg", "jidan", true, 1));
        menu1.add(new MenuItem("milk", "niunai", true, 4.5));
        menu1.add(new MenuItem("bun", "baozi", false, 2.5));

        menu2.add(new MenuItem("noodle","miantiao",true,22));

        menu3.add(new MenuItem("steak","niupai",false,69));
        menu3.add(menu4);

        menu4.add(new MenuItem("cake","dangao",true,39));

        Waitress waitress = new Waitress(allMenu);
//        waitress.print();
        waitress.printVegetarian();

    }



}
