package com.wink.learn.designpattern.command.equipment;

/**
 * description: BedRoomLight <br>
 * date: 2021/6/2 下午3:55 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class BedRoomLight implements Light {
    @Override
    public void on() {
        System.out.println("BedRoomLight is on === ");
    }

    @Override
    public void off() {
        System.out.println("BedRoomLight is off === ");
    }
}
