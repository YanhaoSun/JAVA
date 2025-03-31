package 线性表.数组.双指针技巧.快慢指针.原地修改;

/**
 * 力扣26
 * easy
 */
public class removeDuplicates {
    public static int solution(int[] nums) {
        int fast = 0;
        int slow = 0;
        if (nums.length==0){
            return 0;
        }
        while (fast<nums.length){
            if (nums[fast]!=nums[slow]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
    public static int solution1(int[] nums){
        int fast = 0;
        int slow = 0;
        if (nums.length==0){
            return 0;
        }
        while (fast<nums.length){
            if (nums[fast]!=nums[slow]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
