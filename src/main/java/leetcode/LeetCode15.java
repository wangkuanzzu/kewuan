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
        int[] ints = new int[]{3,0,-2,-1,1,2};
        System.out.println(threeSum(ints));
    }

    //满足时间复杂度N^2
    public static List<List<Integer>> threeSum(int[] nums) {
        //排序 {-4,-1,-1,0,1,2}
        Arrays.sort(nums);
        //总长度
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //三个指针 first second third
        for (int first = 0; first < length; first++) {
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            int third = length-1;
            int target = -nums[first];

            for (int second = first + 1; second < length; second++) {
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }

                while(second < third && nums[second] + nums[third] > target){
                    third--;
                }

                if(second == third){
                    break;
                }

                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
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
