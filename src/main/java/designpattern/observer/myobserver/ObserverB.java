package designpattern.observer.myobserver;

/**
 * description: ObserverB <br>
 * date: 2021/5/26 下午5:29 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ObserverB extends Observer {
    //在调用构造函数时候 实现注册
    public ObserverB(Subject subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println("B receive change " + subject.getState());
    }
}
