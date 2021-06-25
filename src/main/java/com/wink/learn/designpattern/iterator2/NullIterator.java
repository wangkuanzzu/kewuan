package com.wink.learn.designpattern.iterator2;

import java.util.Iterator;

/**
 * description: NullIterator <br>
 * date: 2021/6/25 下午2:33 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class NullIterator implements Iterator<MenuComponent> {

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }
}
