package com.wink.learn.designpattern.iterator;

import java.util.Iterator;

/**
 * description: BreakFirstIterator <br>
 * date: 2021/6/9 下午5:06 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class BreakFirstIterator implements Iterator {

    MenuItem[] menuItems;
    int position = 0;

    public BreakFirstIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position <= menuItems.length && menuItems[position] != null;
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems[position];
        position = position + 1;
        return menuItem;
    }
}
