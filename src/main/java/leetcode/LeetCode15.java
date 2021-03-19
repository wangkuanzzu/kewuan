package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * description: LeetCode15 <br>
 * date: 2021/3/16 上午10:21 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode15 {

    public static void main(String[] args) {
        int[] ints = new int[]{-1,0,1,2,-1,-4};
        threeSum(ints);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0 ){
            return Collections.EMPTY_LIST;
        }
        HashSet<List<Integer>> hashSet = new HashSet<>();
        //开始找三个数
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        return new ArrayList<>(hashSet);
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 弱智算法，已放弃
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum0000(int[] nums) {
        if(nums.length == 0 ){
            return Collections.EMPTY_LIST;
        }
        HashSet<List<Integer>> hashSet = new HashSet<>();
        //开始找三个数
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length ; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        hashSet.add(list);
                    }
                }

            }
        }
        return new ArrayList<>(hashSet);
    }

}
