package com.wink.learn.designpattern.factory.abstractt.factory;

import com.wink.learn.designpattern.factory.abstractt.Ingredient.Cheese;
import com.wink.learn.designpattern.factory.abstractt.Ingredient.CheeseA;
import com.wink.learn.designpattern.factory.abstractt.Ingredient.Clams;
import com.wink.learn.designpattern.factory.abstractt.Ingredient.ClamsA;
import com.wink.learn.designpattern.factory.abstractt.Ingredient.Dough;
import com.wink.learn.designpattern.factory.abstractt.Ingredient.DoughA;
import com.wink.learn.designpattern.factory.abstractt.Ingredient.Sauce;
import com.wink.learn.designpattern.factory.abstractt.Ingredient.SauceA;

/**
 * description: NYPizzaIngredientFactory <br>
 * date: 2021/6/1 下午1:34 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return new DoughA();
    }

    @Override
    public Sauce createSauce() {
        return new SauceA();
    }

    @Override
    public Cheese createCheese() {
        return new CheeseA();
    }

    @Override
    public Clams createClams() {
        return new ClamsA();
    }
}
