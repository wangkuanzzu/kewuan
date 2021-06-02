package designpattern.command.commands;

import designpattern.command.equipment.BedRoomLight;

/**
 * description: BedRoomLightOnCommand <br>
 * date: 2021/6/2 下午4:30 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class BedRoomLightOnCommand implements Commands {

    BedRoomLight bedRoomLight;

    public BedRoomLightOnCommand(BedRoomLight bedRoomLight) {
        this.bedRoomLight = bedRoomLight;
    }

    @Override
    public void execute() {
        bedRoomLight.on();
    }
}
