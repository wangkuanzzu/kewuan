package future.food;

public class CodeDishThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("凉菜准备完毕");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
