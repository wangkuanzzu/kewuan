package designpattern.command.commands;

import designpattern.command.equipment.AirConditionHang;

/**
 * description: AirConditionOnCommand <br>
 * date: 2021/6/2 下午5:12 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class AirConditionOnCommand implements Commands {

    AirConditionHang airCondition;

    public AirConditionOnCommand(AirConditionHang airCondition) {
        this.airCondition = airCondition;
    }

    @Override
    public void execute() {
        airCondition.on();
        airCondition.setTemperature(26.5);
    }
}
