package com.wink.learn.designpattern.iterator2;

import java.util.Iterator;

/**
 * description: MenuComponent <br>
 * date: 2021/6/24 上午10:18 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public abstract class MenuComponent {

    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

    public String getDescription(){
        throw new UnsupportedOperationException();
    }

    public Double getPrice(){
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian(){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }

    public abstract Iterator<MenuComponent> createIterator();

}
