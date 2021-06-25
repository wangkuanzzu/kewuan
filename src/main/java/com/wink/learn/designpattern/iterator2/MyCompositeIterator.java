package com.wink.learn.designpattern.iterator2;

import java.util.Iterator;
import java.util.Stack;

/**
 * description: MyCompositeIterator <br>
 * date: 2021/6/25 下午3:12 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MyCompositeIterator implements Iterator<MenuComponent> {
    //声明一个栈存储
    Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public MyCompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        }else {
            Iterator<MenuComponent> peek = stack.peek();
            if (!peek.hasNext()) {
                stack.pop();
                return hasNext();
            }else {
                return true;
            }
        }

    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator<MenuComponent> peek = stack.peek();
            MenuComponent next = peek.next();
            if (next instanceof Menu) {
                stack.push(next.createIterator());
            }
            return next;
        }else {
            return null;
        }

    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
