package com.wink.learn.designpattern.command.equipment;

/**
 * description: AirConditionHang <br>
 * date: 2021/6/2 下午5:16 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class AirConditionHang implements AirCondition {

    @Override
    public void on() {
        System.out.println(" ===== AirConditionHang on ===== ");
    }

    @Override
    public void off() {
        System.out.println(" ===== AirConditionHang off ===== ");
    }

    @Override
    public void setTemperature(Double t) {
        System.out.println(" ===== AirConditionHang on temperature ===== " + t);
    }
}
