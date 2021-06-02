package designpattern.command.commands;

/**
 * description: NoCommand <br>
 * date: 2021/6/2 下午4:35 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class NoCommand implements Commands {

    public NoCommand() {
    }

    @Override
    public void execute() {
        System.out.println("do nothing ===== ");
    }
}
