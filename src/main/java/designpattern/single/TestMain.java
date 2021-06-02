package designpattern.single;

/**
 * description: TestMain <br>
 * date: 2021/6/2 下午2:36 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    public static void main(String[] args) {

        SingleObject singleObject = SingleObject.getInstance();
        singleObject.showMessage();

        SingleTon singleTon = SingleTon.getInstance();
        singleTon.showMessage();

    }
}
