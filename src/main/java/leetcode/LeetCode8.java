package leetcode;

/**
 * description: LeetCode8 <br>
 * date: 2021/3/10 下午1:29 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode8 {

    public static void main(String[] args) {

// 单个字符
        System.out.println(myAtoi(" ")) ;
        System.out.println(myAtoi("+")) ;
        System.out.println(myAtoi("-")) ;
        System.out.println(myAtoi(".")) ;
        System.out.println(myAtoi("a")) ;
        System.out.println(myAtoi("+-"));
//System.out.println(m.out.println(myAtoi(' 12'))# 12
        System.out.println(myAtoi(" 12 "));
        System.out.println(myAtoi("+12")) ;
        System.out.println(myAtoi("12+")) ;
        System.out.println(myAtoi("-+12"));
        System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("12-+")) ;
        System.out.println(myAtoi(".14159"));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("91283472332"));

        System.out.println(myAtoi("00000-42a1234"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("-2147483648"));
// 多个组合
        System.out.println(myAtoi("   +0 123"));

    }


    /**
     * 首先我们只循环一遍字符串，初始化结果0
     * 第一步：处理前面的空格，如果都是空格，返回0
     * 第二步：找到第一个非空字符，判断正负，记录一个标记（该标记用于最终返回）
     * 第三步：循环剩余字符（此时都是正数）
     *          判断是否数字，非数字，跳出循环，返回0
     *          是数字，判断是否超限。条件 或
     *              1、当前结果大于2147483647/10=214748364，直接返回边界值，加上正负号
     *              2、当前结果等于2147483647/10=214748364，且下一个数字大于7，返回边界值，加上正负号
     *          结果计算：结果*10+（下一个数字-0）
     *  第四步：加上正负号标记，返回最终结果
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int i = 0, len = s.length();
        int res = 0, firstChar = 1; // // firstChar 表示正负号，默认为 '+'，即 1
        int upperBound = Integer.MAX_VALUE / 10;
        char[] chars = s.toCharArray();
        while (chars[i] == ' ') {
            // 省去所有空格
            if (++i >= len) {
                return 0;
            }
        }

        if (chars[i] == '-') {
            // 判断正负号
            firstChar = -1;
        }

        if (chars[i] == '+' || chars[i] == '-') {
            i++;
        }

        for (; i < len; ++i) {
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }

            if (res > upperBound || (res == upperBound && chars[i] > '7')) {
                // 判断下一次计算是否会越界
                return firstChar == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (chars[i] - '0');
        }

        return firstChar * res;
    }
}
