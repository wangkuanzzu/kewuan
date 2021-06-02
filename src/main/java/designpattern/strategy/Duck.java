package designpattern.strategy;

/**
 * description: Duck <br>
 * date: 2021/5/26 上午9:30 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Duck {
    String skinColor;

    public Duck() {
    }

    public Duck(String skinColor) {
        this.skinColor = skinColor;
    }

    void display(){
        System.out.println("i am " + skinColor + " duck");
    };
}
