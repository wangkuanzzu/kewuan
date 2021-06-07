package designpattern.template;

/**
 * description: Tea <br>
 * date: 2021/6/7 上午10:36 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Tea extends CaffeineBeverage{

    private boolean add;

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    @Override
    void brew() {
        System.out.println(" =打开茶罐，一丢丢茶叶= ");
    }

    @Override
    void addCondiments() {
        System.out.println(" =添加柠檬，变身柠檬茶= ");
    }

    @Override
    boolean addNothing() {
        return add;
    }
}
