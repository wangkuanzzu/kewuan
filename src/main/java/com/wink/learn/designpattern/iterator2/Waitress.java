package com.wink.learn.designpattern.iterator2;

import java.util.Iterator;

/**
 * description: Waitress <br>
 * date: 2021/6/25 下午1:33 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Waitress {

    MenuComponent allMenu;

    public Waitress(MenuComponent allMenu) {
        this.allMenu = allMenu;
    }

    public void print(){
        allMenu.print();
    }

    public void printVegetarian(){
        Iterator<MenuComponent> iterator = allMenu.createIterator();
        System.out.println("==========素菜==============");
        while (iterator.hasNext()) {
            MenuComponent next = iterator.next();
            try {
                if (next.isVegetarian()) {
                    next.print();
                }
            }catch (UnsupportedOperationException ignored){

            }
        }
    }
}
