package 线性表.数组.双指针技巧.快慢指针.原地修改;

import list.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣283
 * easy
 */
public class MoveZeros {
    public static void solution(int[] nums){
        int index = removeElement(nums);
        for (int i = index; i<nums.length; i++){
            nums[i] = 0;
        }
    }
    public static int removeElement(int[] nums){
        int fast = 0;
        int slow = 0;
        while (fast<nums.length){
            if (nums[fast]!=0){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
    }
}
