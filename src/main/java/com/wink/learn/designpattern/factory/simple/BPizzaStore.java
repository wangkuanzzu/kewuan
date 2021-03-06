package com.wink.learn.designpattern.factory.simple;

import com.wink.learn.designpattern.factory.A1Pizza;
import com.wink.learn.designpattern.factory.A2Pizza;
import com.wink.learn.designpattern.factory.A3Pizza;
import com.wink.learn.designpattern.factory.B1Pizza;
import com.wink.learn.designpattern.factory.Pizza;
import com.wink.learn.designpattern.factory.abstractt.factory.ChicagoPizzaIngredientFactory;
import com.wink.learn.designpattern.factory.abstractt.factory.NYPizzaIngredientFactory;
import com.wink.learn.designpattern.factory.abstractt.factory.PizzaIngredientFactory;

/**
 * description: SimplePizzaFactory <br>
 * date: 2021/5/31 下午6:15 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class BPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        if ("B1".equals(pizzaType)) {
            pizza = new B1Pizza(ingredientFactory);
            pizza.setName("B1");
        }
        return pizza;
    }
}
