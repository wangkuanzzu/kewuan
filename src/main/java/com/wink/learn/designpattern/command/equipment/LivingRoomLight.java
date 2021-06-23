package com.wink.learn.designpattern.command.equipment;

/**
 * description: LivingRoomLight <br>
 * date: 2021/6/2 下午3:59 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LivingRoomLight implements Light {
    @Override
    public void on() {
        System.out.println("LivingRoomLight is on ===");
    }

    @Override
    public void off() {
        System.out.println("LivingRoomLight is off ===");
    }
}
