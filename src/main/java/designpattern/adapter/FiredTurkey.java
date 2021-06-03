package designpattern.adapter;

/**
 * description: FiredTurkey <br>
 * date: 2021/6/3 下午3:33 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class FiredTurkey implements Turkey {

    @Override
    public void cuckoo() {
        System.out.println("=== 咕咕 ===");
    }

    @Override
    public void fly() {
        System.out.println("=== 飞了二米 ===");
    }
}
