package designpattern.observer.jdk;

import java.util.Observable;

/**
 * description: Subject <br>
 * date: 2021/5/27 上午9:27 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Subject extends Observable {

    private int state;

    public int getState() {
        return state;
    }

    //被观察者 发生改变
    public void setState(int state) {
        if (this.state != state) {
            this.state = state;
            //值发生改变
            setChanged();
        }
        //通知各观察者
        notifyObservers(state);
    }
}
