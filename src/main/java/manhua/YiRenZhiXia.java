package manhua;

/**
 * description: YiRenZhiXia <br>
 * date: 2020/12/17 下午4:43 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class YiRenZhiXia {

    private String name;

    public YiRenZhiXia(){
        System.out.println("构造方法执行1");
    }

    public YiRenZhiXia(String name){
        System.out.println("构造方法执行2");
        this.name = name;
    }

    static int age = 18;

    {
        System.out.println("非静态代码块");
    }

    static {
        System.out.println("静态代码块执行");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
