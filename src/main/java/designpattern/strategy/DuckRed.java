package designpattern.strategy;

/**
 * description: RedDuck <br>
 * date: 2021/5/26 上午9:43 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
// 客户一号
public class DuckRed extends Duck {

    //组合 鸭子所具备的技能
    private QuarkBehavior quarkBehavior;
    private FlyBehavior flyBehavior;

    public DuckRed() {
        super();
    }

    public DuckRed(QuarkBehavior quarkBehavior, FlyBehavior flyBehavior) {
        super("red red");
        this.quarkBehavior = quarkBehavior;
        this.flyBehavior = flyBehavior;
    }

    public void display(){
        System.out.println("i am a " + skinColor + " duck !");
    }

    public void quark(){
        quarkBehavior.quark();
    }

    public void fly(){
        flyBehavior.fly();
    }

    public void setQuarkBehavior(QuarkBehavior quarkBehavior) {
        this.quarkBehavior = quarkBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
