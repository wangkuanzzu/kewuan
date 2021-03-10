package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * description: LeetCode6 <br>
 * date: 2021/3/9 下午4:28 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode6 {

    public static void main(String[] args) {
        String s = "ABCDEFGH";
        System.out.println(convert(s,3));
    }

    // ABCDEFGHIJKLMN
    public  static String convert(String s, int numRows) {
        //判断如果为一行，直接返回
        if(numRows == 1){return s;}

        //构建数据结构
        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0; i< Math.min(s.length(),numRows); i++){
            rows.add(new StringBuilder());
        }

        //解析数据
        int numRow = 0;
        boolean upDownFlag = false; //false: 向下 true 向上
        //从左向右循环字符串，判断每一个字符串应该在哪一行
        for(char a:s.toCharArray()){
            rows.get(numRow).append(a);
            if(numRow == 0 ){
                //向下偏移
                upDownFlag = false;
            }
            if(numRow == numRows-1){
                upDownFlag = true;
            }
            numRow += upDownFlag ? -1 : +1;
        }

        StringBuilder ret = new StringBuilder();
        for(StringBuilder row:rows){
            ret.append(row);
        }
        return ret.toString();
    }

}
