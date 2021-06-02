package designpattern.decorate.mydecorate;

/**
 * description: XiMian <br>
 * date: 2021/5/27 上午11:21 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class DaoXiaoMian extends Noodles {

    @Override
    public String getDescription() {
        return "老板来一份刀削面。" ;
    }

    @Override
    public double price() {
        return 1.0;
    }
}
