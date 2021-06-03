package designpattern.adapter;

/**
 * description: AdapterTurkey <br>
 * date: 2021/6/3 下午4:21 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class AdapterTurkey implements Duck {

    Turkey turkey;

    public AdapterTurkey(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quark() {
        turkey.cuckoo();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
