package designpattern.iterator;

import java.util.Iterator;
import java.util.OptionalInt;

/**
 * description: BreakFirstMenu <br>
 * date: 2021/6/9 下午3:27 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class BreakFirstMenu implements Menu{
    static final int MAX_ITEMS = 8;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public BreakFirstMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem(new MenuItem("A",10,"AAAAAAA",true));
        addItem(new MenuItem("B",20,"BBBBBBB",true));
        addItem(new MenuItem("C",30,"CCCCCCC",true));
        addItem(new MenuItem("D",40,"DDDDDDD",false));
    }

    public BreakFirstMenu(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    public void addItem(MenuItem menuItem){
        if(numberOfItems >= MAX_ITEMS){
            System.err.println("不能再加菜了");
        }else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

    @Override
    public Iterator createIterator() {
        return new BreakFirstIterator(menuItems);
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }
}
