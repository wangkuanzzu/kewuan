package future.food;

public class ThreadMode {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread bumThread = new BumThread();
        bumThread.start();
        bumThread.join();

        Thread codeDishThread = new CodeDishThread();
        codeDishThread.start();
        codeDishThread.join();

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));

    }
}
