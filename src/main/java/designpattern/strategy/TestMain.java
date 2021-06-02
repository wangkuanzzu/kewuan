package designpattern.strategy;

/**
 * description: TestMain <br>
 * date: 2021/5/26 上午10:09 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    public static void main(String[] args) {
        QuarkGuaGua quarkGuaGua = new QuarkGuaGua();
        FlyByWing flyByWing = new FlyByWing();
        DuckRed duckRed = new DuckRed(quarkGuaGua,flyByWing);
        duckRed.display();
        duckRed.quark();
        duckRed.setQuarkBehavior(new QuarkZiZi());
        duckRed.quark();
        duckRed.fly();
    }
}
