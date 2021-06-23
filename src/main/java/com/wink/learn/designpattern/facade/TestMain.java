package com.wink.learn.designpattern.facade;

/**
 * description: TestMain <br>
 * date: 2021/6/4 上午10:06 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    public static void main(String[] args) {

        /*
            外观模式
            将一些复杂的接口进行整理合并
            然后对外提供更少的接口
            实现更多的功能
         */

        Computer computer = new Computer();
        Game game = new Game();
        Cocacola cocacola = new Cocacola();

        PlayComputerGame playComputerGame = new PlayComputerGame(computer,game,cocacola);
        playComputerGame.play();

        playComputerGame.over();

    }

}
