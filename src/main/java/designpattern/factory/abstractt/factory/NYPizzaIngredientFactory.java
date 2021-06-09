package designpattern.factory.abstractt.factory;

import designpattern.factory.abstractt.Ingredient.Cheese;
import designpattern.factory.abstractt.Ingredient.CheeseA;
import designpattern.factory.abstractt.Ingredient.Clams;
import designpattern.factory.abstractt.Ingredient.ClamsA;
import designpattern.factory.abstractt.Ingredient.Dough;
import designpattern.factory.abstractt.Ingredient.DoughA;
import designpattern.factory.abstractt.Ingredient.Sauce;
import designpattern.factory.abstractt.Ingredient.SauceA;

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
