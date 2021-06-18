package designpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * description: LunchMenu <br>
 * date: 2021/6/9 下午3:32 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LunchMenu implements Menu{
    ArrayList<MenuItem> menuItems;

    public LunchMenu() {
        menuItems = new ArrayList<>();
        addItem(new MenuItem("X",100,"XXXXXXX",true));
        addItem(new MenuItem("Y",200,"YYYYYYY",false));
        addItem(new MenuItem("Z",100,"ZZZZZZZ",true));
    }

    public LunchMenu(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addItem(MenuItem menuItem){
        menuItems.add(menuItem);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public Iterator createIterator() {
        return menuItems.iterator();
    }
}
