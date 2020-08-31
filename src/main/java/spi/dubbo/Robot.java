package spi.dubbo;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * description: Reboot <br>
 * date: 2020/8/28 4:06 下午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
@SPI
public interface Robot {

    void sayHello();
}
