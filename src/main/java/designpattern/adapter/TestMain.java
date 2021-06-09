package designpattern.adapter;

/**
 * description: TestMain <br>
 * date: 2021/6/3 下午4:22 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    /*
    适配器模式
        lighting接口 如何使用 3.5毫米接口的耳机
        由于接口不一致，我们需要一个东西将3.5毫米接口转换成lighting接口
        此时，我们要完成这样一个转换头
        首先要实现lighting接口，支持声音的输出和输入
        转换头内部需要支持从3.5毫米接口的耳机实现声音的输出和输入
        例如：当调用输出声音时候，转换头收到请求，然后调用3.5毫米接口的耳机的输出声音
     */

    public static void main(String[] args) {

        Turkey turkey = new FiredTurkey();
        AdapterTurkey adapterTurkey = new AdapterTurkey(turkey);

        Duck duck = new YellowDuck();

        duck.quark();
        duck.fly();

        adapterTurkey.quark();
        adapterTurkey.fly();

    }
}
