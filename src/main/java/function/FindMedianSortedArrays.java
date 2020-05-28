package function;

/**
 * Description:找出两个有序数组的中位数
 * <p>
 * Created By kuan on 2020/1/15
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] num1 = {2};
        int[] num2 = {1,3,4};

        int len1 = num1.length;
        int len2 = num2.length;
        System.out.println(len1+ "===" + len2);
        int left = (len1+len2+1)/2;
        int right = (len1+len2+2)/2;
        System.out.println(left+ "===" + right);
        // 两个数组的总长度为奇数，获取中间的数两次，求均值（该中位数本身）left=right
        // 两个数组的总长度为偶数，获取中间的两个数，求均值 left+1=right
        double ans = (getKth(num1,0,len1-1,num2,0,len2-1, left)+getKth(num1,0,len1-1,num2,0,len2-1, right))*0.5;
        System.out.println(ans);
    }

    // 获取两个数组合并后第k位置的数
    public static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        // 两个数组其中一个为空
        if (len1 == 0){
            return nums2[start2+k-1];
        }
        if (len2 == 0){
            return nums1[start1+k-1];
        }

        // 两个数组均不为空
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
