package com.wink.learn.designpattern.command.commands;

import com.wink.learn.designpattern.command.equipment.BedRoomLight;

/**
 * description: BedRoomLightOffCommand <br>
 * date: 2021/6/2 下午4:33 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class BedRoomLightOffCommand implements Commands {

    BedRoomLight bedRoomLight;

    public BedRoomLightOffCommand(BedRoomLight bedRoomLight) {
        this.bedRoomLight = bedRoomLight;
    }

    @Override
    public void execute() {
        bedRoomLight.off();
    }
}
