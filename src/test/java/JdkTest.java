import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;
import spi.jdk.Robot;

import java.util.ServiceLoader;

/**
 * description: DubboTest <br>
 * date: 2020/8/28 4:13 下午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class JdkTest {

    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
