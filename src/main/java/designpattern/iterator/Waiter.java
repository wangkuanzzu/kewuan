package designpattern.iterator;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * description: Waiter <br>
 * date: 2021/6/9 下午4:17 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Waiter {
    BreakFirstMenu breakFirstMenu;
    LunchMenu lunchMenu;
    DinnerMenu dinnerMenu;

    public Waiter() {
    }

    public Waiter(BreakFirstMenu breakFirstMenu, LunchMenu lunchMenu, DinnerMenu dinnerMenu) {
        this.breakFirstMenu = breakFirstMenu;
        this.lunchMenu = lunchMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu() {
        MenuItem[] menuItems = breakFirstMenu.getMenuItems();
        ArrayList<MenuItem> menuItems1 = lunchMenu.getMenuItems();
        HashMap<String, MenuItem> menuItems2 = dinnerMenu.getMenuItems();
        for (int i = 0; i < breakFirstMenu.numberOfItems; i++) {
            System.out.println(menuItems[i].toString());
        }
        menuItems1.forEach(menuItem -> {
            System.out.println(menuItem.toString());
        });

        menuItems2.forEach((s, menuItem) -> {
            System.out.println(s);
            System.out.println(menuItem.toString());
        });
    }

    public BreakFirstMenu getBreakFirstMenu() {
        return breakFirstMenu;
    }

    public void setBreakFirstMenu(BreakFirstMenu breakFirstMenu) {
        this.breakFirstMenu = breakFirstMenu;
    }

    public LunchMenu getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(LunchMenu lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public DinnerMenu getDinnerMenu() {
        return dinnerMenu;
    }

    public void setDinnerMenu(DinnerMenu dinnerMenu) {
        this.dinnerMenu = dinnerMenu;
    }
}
