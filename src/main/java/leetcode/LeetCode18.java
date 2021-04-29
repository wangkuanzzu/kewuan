package leetcode;

/**
 * description: LeetCode18 <br>
 * date: 2021/4/28 下午1:34 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 */
public class LeetCode18 {

    public static void main(String[] args) {
        int[] ints = new int[]{1,0,-1,0,-2,2};
        int target =0;
        System.out.println(fourSum(ints, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return ans;
        }
        int length = nums.length;
        Arrays.sort(nums);
        //两层循环 i,j（使用指针） + 双指针(left right)
        for (int i = 0; i < length - 3; i++) {
            //如果相邻两个值相等 就跳过
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //如果最小的四个值相加 大于 target 直接结束循环
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }
            //最小值加上最大的三个值 小于 target 向右移动判断第二最小值
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {

                //如果相邻两个值相等 就跳过
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                //如果最小的四个值相加 大于 target 直接结束循环
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //最小值加上最大的两个值 小于 target 向右移动判断第二最小值
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                int left = j + 1, right = length-1;
                while(left < right){
                    int sum = nums[i] + nums[j] +nums[left] +nums[right];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i] , nums[j] , nums[left] , nums[right]));
                        while(left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                        while(left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if(sum < target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}
