package com.wink.learn.designpattern.facade;

/**
 * description: PlayGame <br>
 * date: 2021/6/4 上午10:31 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class PlayComputerGame {

    Computer computer;
    Game game;
    Cocacola cocacola;

    public PlayComputerGame(Computer computer, Game game, Cocacola cocacola) {
        this.computer = computer;
        this.game = game;
        this.cocacola = cocacola;
    }

    public void play() {
        computer.on();
        cocacola.ready();
        for (int i = 0; i < 3; i++) {
            game.begin();
            cocacola.drink();
            game.finish();
        }
    }

    public void over(){
        computer.off();
    }

}
