package designpattern.observer.myobserver;

/**
 * description: TestMain <br>
 * date: 2021/5/26 下午5:37 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    public static void main(String[] args) {
        Subject subject = new Subject();

        ObserverA observerA = new ObserverA(subject);
        ObserverB observerB = new ObserverB(subject);
        System.out.println("===10==== ");
        subject.setState(10);
        System.out.println("===20==== ");
        subject.setState(20);

    }

}
