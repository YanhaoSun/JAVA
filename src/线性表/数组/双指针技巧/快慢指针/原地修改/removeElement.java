package 线性表.数组.双指针技巧.快慢指针.原地修改;

/**
 * 力扣27
 * easy
 */
public class removeElement {
    public static int solution(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast<nums.length){
            if (nums[fast]!=val){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        for (int a: nums){
            System.out.println(a);
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,2,2,3};
        solution(array, 3);
    }
}
