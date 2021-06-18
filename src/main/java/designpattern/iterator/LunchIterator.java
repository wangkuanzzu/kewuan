package designpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * description: LunchIterator <br>
 * date: 2021/6/10 上午10:04 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LunchIterator implements Iterator {
    ArrayList<MenuItem> menuItems;
    int position = 0;

    public LunchIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position <= menuItems.size() && menuItems.get(position) != null;
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems.get(position);
        position = position + 1;
        return menuItem;
    }
}
