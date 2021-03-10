package leecode;

import org.bouncycastle.util.Strings;

/**
 * description: LeetCode7 <br>
 * date: 2021/3/9 下午5:19 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode7 {

    public static void main(String[] args) {
        System.out.println(reverse(0));
        System.out.println(reverse(199));
        System.out.println(reverse(-120));

    }

    public static int reverse(int x) {

        int ret;
        String s;
        boolean b = true;
        //校验正负
        if(x < 0){
            b = false;
            s = String.valueOf(Math.abs(x));
        }else{
            s = String.valueOf(x);
        }
        //反转s
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=s.length(); i >0; i--){
            stringBuilder.append(s.charAt(i-1));
        }
        // 捕获异常
        try{
             ret = Integer.parseInt(stringBuilder.toString());
        }catch (Exception e){
            return 0;
        }
        return b ? ret : - ret;

    }
}
