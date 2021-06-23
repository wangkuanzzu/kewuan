package com.wink.learn.designpattern.factory.abstractt.factory;

import com.wink.learn.designpattern.factory.abstractt.Ingredient.Cheese;
import com.wink.learn.designpattern.factory.abstractt.Ingredient.Clams;
import com.wink.learn.designpattern.factory.abstractt.Ingredient.Dough;
import com.wink.learn.designpattern.factory.abstractt.Ingredient.Sauce;

/**
 * description: PizzaIngredientFactory <br>
 * date: 2021/6/1 上午11:55 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Clams createClams();
}
