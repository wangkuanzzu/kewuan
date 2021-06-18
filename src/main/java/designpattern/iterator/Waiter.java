package designpattern.iterator;

import java.util.Iterator;

/**
 * description: Waiter <br>
 * date: 2021/6/9 下午4:17 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Waiter {
    Menu breakFirstMenu;
    Menu lunchMenu;

    public Waiter() {
    }

    public Waiter(Menu breakFirstMenu, Menu lunchMenu) {
        this.breakFirstMenu = breakFirstMenu;
        this.lunchMenu = lunchMenu;
    }

    public void printMenu() {
        Iterator iterator = breakFirstMenu.createIterator();
        Iterator iterator1 = lunchMenu.createIterator();
        System.out.println("早餐");
        printMenu(iterator);
        System.out.println("午餐");
        printMenu(iterator1);
    }

    private void printMenu(Iterator iterator){
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem)iterator.next();
            System.out.println(menuItem.getName() +" == "+menuItem.getPrice() + " == " +menuItem.getDescription());
        }
    }
}
