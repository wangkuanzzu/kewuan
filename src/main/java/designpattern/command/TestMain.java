package designpattern.command;

import designpattern.command.commands.AirConditionOffCommand;
import designpattern.command.commands.AirConditionOnCommand;
import designpattern.command.commands.BedRoomLightOffCommand;
import designpattern.command.commands.BedRoomLightOnCommand;
import designpattern.command.equipment.AirConditionHang;
import designpattern.command.equipment.BedRoomLight;

/**
 * description: TestMain <br>
 * date: 2021/6/2 下午4:51 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        BedRoomLight bedRoomLight = new BedRoomLight();
        AirConditionHang airConditionHang = new AirConditionHang();

        BedRoomLightOnCommand bedRoomLightOnCommand = new BedRoomLightOnCommand(bedRoomLight);
        BedRoomLightOffCommand bedRoomLightOffCommand = new BedRoomLightOffCommand(bedRoomLight);

        AirConditionOnCommand airConditionOnCommand = new AirConditionOnCommand(airConditionHang);
        AirConditionOffCommand airConditionOffCommand = new AirConditionOffCommand(airConditionHang);

        remoteControl.setCommands(0,bedRoomLightOnCommand,bedRoomLightOffCommand);
        remoteControl.setCommands(1,airConditionOnCommand,airConditionOffCommand);
        remoteControl.whenOnButtonWasPressed(0);
        remoteControl.whenOnButtonWasPressed(1);
        System.out.println("====chui le yi hui kong tiao jue de leng====");
        remoteControl.whenOffButtonWasPressed(1);
        System.out.println("====dao shui jiao shi jian le ====");
        remoteControl.whenOffButtonWasPressed(0);

    }
}
