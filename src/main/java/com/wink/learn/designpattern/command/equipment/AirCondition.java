package com.wink.learn.designpattern.command.equipment;

/**
 * description: AirCondition <br>
 * date: 2021/6/2 下午3:50 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public interface AirCondition {

    void on();
    void off();
    void setTemperature(Double t);
}
