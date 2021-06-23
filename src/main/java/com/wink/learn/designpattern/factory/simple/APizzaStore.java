package com.wink.learn.designpattern.factory.simple;

import com.wink.learn.designpattern.factory.A1Pizza;
import com.wink.learn.designpattern.factory.A2Pizza;
import com.wink.learn.designpattern.factory.A3Pizza;
import com.wink.learn.designpattern.factory.Pizza;
import com.wink.learn.designpattern.factory.abstractt.factory.NYPizzaIngredientFactory;
import com.wink.learn.designpattern.factory.abstractt.factory.PizzaIngredientFactory;

/**
 * description: SimplePizzaFactory <br>
 * date: 2021/5/31 下午6:15 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class APizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        //不同的商店使用的原料不一致
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        switch (pizzaType) {
            case "A1":
                pizza = new A1Pizza(ingredientFactory);
                pizza.setName("A1");
                return pizza;
            case "A2":
                pizza = new A2Pizza(ingredientFactory);
                pizza.setName("A2");
                return pizza;
            case "A3":
                pizza = new A3Pizza(ingredientFactory);
                pizza.setName("A3");
                return pizza;
            default:
                return null;
        }

    }
}
