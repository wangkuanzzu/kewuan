package hutool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * description: TestFile <br>
 * date: 2020/10/18 12:23 下午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestFile {

        public static void main(String args[]) throws IOException {
            FileInputStream inputStream = new FileInputStream("/Users/kuan/temp/哈哈");
            FileOutputStream outputStream = new FileOutputStream("/Users/kuan/temp/哼哼");

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len=inputStream.read(bytes)) != -1) {
                outputStream.write(bytes,0,len);
            }
            inputStream.close();
            outputStream.close();
        }
}
