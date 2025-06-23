package 线性表.数组.强化练习数组双指针经典习题;

import java.util.HashMap;

/**
 * 力扣80
 * medium
 */
public class RemoveDuplicatesFromSortedArrayII {
    // 解法1
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
            // 如果当前nums[i]的数量<=2, 那么slow和fast一同前进,
            // 如果当前nums[i]的数量>2, 那么slow停止(保留两个), fast继续前进直到遇到新的值
            if (count.get(nums[i])<=2){
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }
    //解法2
    public int removeDuplicates2(int[] nums){
        int fast = 0;
        int slow = 0;
        int count = 0;
        while (fast<nums.length){
            if (nums[slow]!=nums[fast]){
                nums[++slow] = nums[fast];
            } else if (slow<fast && count<2){
                nums[++slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast<nums.length && nums[fast]!=nums[fast-1]){
                count = 0;
            }
        }
        return slow+1;
    }
}
