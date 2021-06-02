package designpattern.factory.simple;

import designpattern.factory.Pizza;

/**
 * description: PizzaStore <br>
 * date: 2021/5/31 下午5:10 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public abstract class PizzaStore {

    //pizza商店定义制作流程
    public Pizza orderPizza(String pizzaType){
        Pizza pizza= createPizza(pizzaType);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    //不同种类的pizza由具体的商店子类实现
    public abstract Pizza createPizza(String pizzaType);
}
