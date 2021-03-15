package leetcode;

import java.util.Objects;

/**
 * description: LeetCode5 <br>
 * date: 2021/3/2 上午9:26 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode5 {


    public static void main(String[] args) {
        String aa = "abcdcdcsf";
        System.out.println(aa.substring(2,6));
        System.out.println(longestPalindrome(aa));
    }
    public static String longestPalindrome(String s) {
        /**
         * 遍历每个字符，比较其前后的第一个字符，一致：继续比较前后第二个字符，以此类推，直到不一致，记录两个位置，一共得到N组
         * 得到两个位置的差值为最大的一组，如果有多个一致，可以都取出来
         * 字符串截取返回回文串
         */
        if(Objects.equals(s,null) || s.length() == 0){
            return "";
        }

        int start = 0,end = 0;
        for(int i= 0; i<s.length(); i++){
            int len1 = expandAroundCenter(s,i,i);//以当前字符为中心
            int len2 = expandAroundCenter(s,i,i+1);//以当前字符和后一个字符整体为中心
            int maxLen = Math.max(len1,len2);
            if(maxLen > end-start){

                start = i-(maxLen-1)/2;
                end = i+maxLen/2;
            }
        }
        return s.substring(start,end+1);
    }
    //得到当前所在字符，前后都一样的最大长度
    public static int expandAroundCenter(String s, int left, int right) {
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }
        //下次循环不符合条件，此时左右下标间的差值增加2
        return right-left-1;
    }
}
