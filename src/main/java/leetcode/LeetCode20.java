package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * description: LeetCode20 <br>
 * date: 2021/4/30 上午11:45 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode20 {

    public static void main(String[] args) {

        String s = "{}()[]()";
        String s1 = "{}()[])";
        String s2 = "{([()";
        System.out.println(isValid(s));
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
    }

    private static boolean isValid(String s) {
        //栈的思想
        int length = s.length();
        if(length%2 == 1){
            return false;
        }
        //定义map 存放相对应的括号
        Map<Character, Character> charPairs = new HashMap<Character, Character>(){{
            put('}','{');
            put(']','[');
            put(')','(');
        }};
        //循环字符 入栈
        Deque<Character> deque = new LinkedList<Character>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(charPairs.containsKey(c)){
                if(deque.isEmpty() || deque.peek() != charPairs.get(c)){
                    return false;
                }
                deque.pop();
            }else {
                deque.push(c);
            }
        }
        System.out.println(deque.iterator());
        return deque.isEmpty();
    }
}
