package com.wink.learn.designpattern.iterator2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * description: Menu <br>
 * date: 2021/6/25 上午11:33 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Menu extends MenuComponent {

    ArrayList<MenuComponent> menuComponents = new ArrayList<>();

    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void print() {
        System.out.println("getName() = " + getName());
        System.out.println("getDescription() = " + getDescription());
        System.out.println("---------------------------------------");
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent me = iterator.next();
            me.print();
        }
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new MyCompositeIterator(menuComponents.iterator());
    }
}
