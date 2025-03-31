package 线性表.数组.实际运用二分搜索的思维框架;

/**
 * 力扣410
 * hard
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        // Arrays.sort(nums);
        return shipWithinDays(nums, k);
    }
    public int shipWithinDays(int[] nums, int days){
        int left = 0, right = 0;
        for (int w: nums){
            left = Math.max(left, w);
            right += w;
        }
        while (left<=right){
            int mid = left+(right-left)/2;
            long daysNeed = daysNeed(nums, mid);
            if (daysNeed == days){
                right = mid-1;
            } else if (daysNeed<days){
                right = mid-1;
            } else if (daysNeed>days){
                left = mid+1;
            }
        }
        return left;
    }
    public long daysNeed(int[] nums, int cap){
        int sum = 0;
        long days = 0;
        for (int i=0; i<nums.length;){
            while (i<nums.length){
                if (sum+nums[i]>cap){
                    break;
                } else {
                    sum += nums[i];
                }
                i++;
            }
            days++;
            sum = 0;
        }
        return days;
    }
}
