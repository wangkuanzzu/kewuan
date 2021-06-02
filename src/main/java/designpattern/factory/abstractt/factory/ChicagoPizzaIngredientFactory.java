package designpattern.factory.abstractt.factory;

import designpattern.factory.abstractt.Ingredient.*;

/**
 * description: NYPizzaIngredientFactory <br>
 * date: 2021/6/1 下午1:34 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return new DoughB();
    }

    @Override
    public Sauce createSauce() {
        return new SauceB();
    }

    @Override
    public Cheese createCheese() {
        return new CheeseB();
    }

    @Override
    public Clams createClams() {
        return new ClamsB();
    }
}
