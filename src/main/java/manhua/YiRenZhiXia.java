package manhua;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HtmlUtil;
import cn.hutool.http.HttpStatus;
import cn.hutool.http.HttpUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

/**
 * description: YiRenZhiXia <br>
 * date: 2020/12/17 下午4:43 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class YiRenZhiXia {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/kuan/temp/yrzx/mulu";
        FileReader fileReader = new FileReader(fileName);
        for (String s:fileReader.readLines()) {
            String href = s.substring(s.indexOf("http"),s.indexOf("html")+4);
            String number = s.substring(s.indexOf("ib")+4,s.length()-4);
//            System.out.println(href + "---" + number);
            //创建每一集目录
            String content = HttpUtil.get(href);
            System.out.println(content);
            break;
        }
    }

}
