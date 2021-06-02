package designpattern.factory;

import designpattern.factory.abstractt.Ingredient.Cheese;
import designpattern.factory.abstractt.Ingredient.Clams;
import designpattern.factory.abstractt.Ingredient.Dough;
import designpattern.factory.abstractt.Ingredient.Sauce;

import java.util.ArrayList;

/**
 * description: Pizza <br>
 * date: 2021/5/31 下午5:16 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public abstract class Pizza {

     String name;
     Dough dough;
     Sauce sauce;
     Clams clams;
     Cheese cheese;

    public abstract void prepare();

    public void bake(){
        System.out.println("bake for 25 minutes at 350");
    }

    public void cut(){
        System.out.println("cut pizza for 9 part");
    }

    public void box(){
        System.out.println("box with box box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", clams=" + clams +
                ", cheese=" + cheese +
                '}';
    }
}
