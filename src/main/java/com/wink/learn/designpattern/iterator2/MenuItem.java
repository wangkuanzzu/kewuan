package com.wink.learn.designpattern.iterator2;

import java.util.Iterator;

/**
 * description: MenuItem <br>
 * date: 2021/6/24 上午10:26 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print() {
        System.out.println("name = " + name);
        System.out.println("description = " + description);
        System.out.println("price = " + price);
        if(isVegetarian()){
            System.out.println("vegetarian = " + vegetarian);
        }
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }
}
