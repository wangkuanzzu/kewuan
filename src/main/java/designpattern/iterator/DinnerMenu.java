package designpattern.iterator;

import java.util.HashMap;

/**
 * description: DinnerMenu <br>
 * date: 2021/6/9 下午3:33 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class DinnerMenu {

    HashMap<String, MenuItem> menuItems;

    public DinnerMenu() {
        menuItems = new HashMap<>();
        addItem(new MenuItem("L",55,"LLLLLL",true));
        addItem(new MenuItem("M",66,"MMMMMM",true));
        addItem(new MenuItem("N",77,"NNNNNN",true));
    }

    public DinnerMenu(HashMap<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addItem(MenuItem menuItem){
        menuItems.put(menuItem.getName(),menuItem);
    }

    public HashMap<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(HashMap<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
