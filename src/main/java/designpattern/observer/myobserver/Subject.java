package designpattern.observer.myobserver;


import java.util.ArrayList;
import java.util.List;

/**
 * description: Subject <br>
 * date: 2021/5/26 下午5:20 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void register(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        int i = observers.indexOf(observer);
        if (i>0) {
            observers.remove(i);
        }
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    private void notifyObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
