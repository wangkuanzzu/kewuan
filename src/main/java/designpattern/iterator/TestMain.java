package designpattern.iterator;

/**
 * description: TestMain <br>
 * date: 2021/6/9 下午3:21 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    /**
     * 迭代器和组合模式
     * 迭代器把数据结构进行隐藏，提供相同方法让你完成数据的获取
     * @param args
     */
    public static void main(String[] args) {

        BreakFirstMenu breakFirstMenu = new BreakFirstMenu();
        LunchMenu lunchMenu = new LunchMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();
        Waiter waiter = new Waiter(breakFirstMenu,lunchMenu,dinnerMenu);
        waiter.printMenu();
    }
}
