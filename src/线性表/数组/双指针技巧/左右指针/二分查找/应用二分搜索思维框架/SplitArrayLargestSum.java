package 线性表.顺序存储结构.Array.双指针技巧.左右指针.二分查找.应用二分搜索思维框架;

/**
 * 力扣410
 * hard
 */
public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int num: nums){
            left = Math.max(left, num);
            right += num;
        }
        while (left<=right){
            int mid = left+(right-left)/2;
            if (numOfSubArray(nums, mid)<=k){
                right = mid-1;
            } else if (numOfSubArray(nums, mid)>k){
                left = mid+1;
            }
        }
        return left;
    }
    public static int numOfSubArray(int[] nums, int maxSum){
        int num = 0;
        for (int i=0; i<nums.length;){
            int x = maxSum;
            while (i<nums.length){
                if (x<nums[i]) break;
                else x -= nums[i];
                i++;
            }
            num++;
        }
        return num;
    }
}
