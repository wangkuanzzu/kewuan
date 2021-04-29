package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: LeetCode17 <br>
 * date: 2021/4/28 上午9:43 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        backtrack(ans,phoneMap,digits,0,new StringBuffer());
        return ans;
    }

    /**
     *
     * @param combinations 结果list
     * @param phoneMap 构建初始化的map
     * @param digits 传入的电话【2-9】
     * @param index digits中每一个数字的下标
     * @param combination 结果list中的一个元素
     */
    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            // abc
            String letters = phoneMap.get(digit);
            // abc的长度3
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static List<String> letterCombinationsLow(String digits) {
        String[] strings = new String[]{
                "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        //digits切分，个数不确定
        String[] digit = digits.split("");
        for (int i = 0; i < digit.length; i++) {
            ans = merge(ans,strings[Integer.parseInt(digit[i])-2].split(""));
        }
        return ans;
    }

    public static List<String> merge(List<String> perResult, String[] next){
        if(perResult.isEmpty()){
            return Arrays.asList(next);
        }
        List<String> result = new ArrayList<>();
        for (String p : perResult) {
            for (String n : next) {
               result.add(p+n);
            }
        }
        return result;
    }
}
