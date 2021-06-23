package com.wink.learn.designpattern.command;

import com.wink.learn.designpattern.command.commands.Commands;
import com.wink.learn.designpattern.command.commands.NoCommand;

import java.util.Arrays;

/**
 * description: RemoteControl <br>
 * date: 2021/6/2 下午4:35 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class RemoteControl {
    Commands[] onCommands;
    Commands[] offCommands;

    //初始化一个没有任何功能的遥控器
    public RemoteControl() {
        onCommands = new Commands[7];
        offCommands = new Commands[7];
        Commands noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    //调用下面的方法给遥控器的每一个按键 设置命令
    public void setCommands(int i, Commands onCommand, Commands offCommand){
        onCommands[i] = onCommand;
        offCommands[i] = offCommand;
    }

    //当遥控器某一个按键被按下
    public void whenOnButtonWasPressed(int i){
        onCommands[i].execute();
    }

    //当遥控器某一个按键被按下
    public void whenOffButtonWasPressed(int i){
        offCommands[i].execute();
    }


    //toString
    @Override
    public String toString() {
        return "RemoteControl{" +
                "onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }
}
