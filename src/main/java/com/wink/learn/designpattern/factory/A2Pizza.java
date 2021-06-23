package com.wink.learn.designpattern.factory;

import com.wink.learn.designpattern.factory.abstractt.factory.PizzaIngredientFactory;

/**
 * description: A1Pizza <br>
 * date: 2021/5/31 下午6:20 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class A2Pizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public A2Pizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    //定制不同pizza 可以包含不同的配料
    @Override
    public void prepare() {
        System.out.println("name = " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        clams = ingredientFactory.createClams();
    }
}
