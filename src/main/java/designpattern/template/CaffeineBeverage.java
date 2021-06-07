package designpattern.template;

/**
 * description: CaffeineBeverage <br>
 * date: 2021/6/7 上午10:19 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public abstract class CaffeineBeverage {

    final void prepare(){
        boilWater();
        brew();
        pourInCup();
        if(!addNothing()){
            addCondiments();
        }
        hook();
    }

    //子类去实现
    abstract void brew();

    abstract void addCondiments();

    //两个一致方法，子类也可以选择性覆盖
    //如果不想子类覆盖，使用final关键字修饰
    void boilWater(){
        System.out.println(" =Boiling Water= ");
    }

    void pourInCup(){
        System.out.println(" =Pouring in cup= ");
    }

    boolean addNothing(){
        return true;
    }

    //子类选择性覆盖
    void hook(){}

}
