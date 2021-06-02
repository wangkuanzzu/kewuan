package designpattern.strategy;

/**
 * description: QuarkQuite <br>
 * date: 2021/5/26 上午9:56 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class QuarkQuiet implements QuarkBehavior {

    @Override
    public void quark() {
        System.out.println("quiet quiet quiet quiet");
    }
}
