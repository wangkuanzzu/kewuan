import com.alibaba.dubbo.common.extension.ExtensionLoader;
import spi.dubbo.Robot;
import org.junit.Test;


/**
 * description: DubboTest <br>
 * date: 2020/8/28 4:13 下午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class DubboTest {


    @Test
    public void sayHello2() throws Exception{
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        System.out.println("Dubbo SPI");
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
