package leecode;

/**
 * description: LeetCode9 <br>
 * date: 2021/3/10 下午4:18 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode9 {

    public static void main(String[] args) {

        System.out.println(isPalindrome(123123));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-10));

    }

    /**
     * 解题思路
     *  第一步：排除特殊情况，负数，非零且最后一位是零
     *  第二步：x/10 得到除去最后一位的值；x%10 得到最后一位
     *         x/10/10 得到除去最后两位的值； x%10 * 10 + x%10%10，得到最后两位的反转值
     *        。。。
     *        比较两个值，直到前者小于等于后者，此时结束while循环
     *  第三步：等于的情况，说明x的位数是偶数
     *         小于的情况，说明x的位数为奇数，此时后者需要除去最后一位，进行比较
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0 || (x%10 == 0 && x != 0) ){
            return false;
        }

        //数字后一半的反转
        int reNum = 0;
        while(x > reNum){
            reNum = reNum*10 + x%10;
            x = x/10;
        }

        return x == reNum || x == reNum/10;

    }
}
