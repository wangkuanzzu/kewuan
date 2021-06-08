package designpattern.template.my;

/**
 * description: TestMain <br>
 * date: 2021/6/4 下午5:32 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    /*
    模版方法
        可以理解成；是一个一般不会发生变化的流程，流程中某一个环节存在些许不一致。
        不一致的环节，由具体的子类去实现，公共且一致的环节，可以有父类去实现。

    附加：钩子方法
        钩子方法定义在一个流程中：可以选择有条件执行或是必须执行
        有条件执行：在父类中定义另一个方法，子类按需实现，返回true和false，控制真正的钩子方法执行
        必须执行： 完全依托于子类实现，可以自定义实现，也可以什么事情都不做

     */
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.setAdd(false);
        tea.prepare();
        System.out.println(" ==== ");
        Coffee coffee = new Coffee();
        coffee.prepare();

    }

}
