import jdk8.thread.pool.MyThread;
import org.junit.Test;

/**
 * description: TestMyThread <br>
 * date: 2021/5/25 下午2:12 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMyThread {

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread("-------"+i);
            myThread.start();
        }
    }
}
