package com.wink.learn.designpattern.iterator;

/**
 * description: MenuItem <br>
 * date: 2021/6/9 下午3:30 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MenuItem {

    String name;
    double price;
    String description;
    boolean hot;

    public MenuItem() {
    }

    public MenuItem(String name, double price, String description, boolean hot) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.hot = hot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", hot=" + hot +
                '}';
    }
}
