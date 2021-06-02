package designpattern.observer.myobserver;

/**
 * description: ObserverA <br>
 * date: 2021/5/26 下午5:29 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ObserverA extends Observer {
    //在调用构造函数时候 完成注册
    public ObserverA(Subject subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println("A receive change " + subject.getState());
    }
}
