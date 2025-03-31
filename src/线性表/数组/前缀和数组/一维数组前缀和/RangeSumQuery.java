package 线性表.数组.前缀和数组.一维数组前缀和;

/**
 * 力扣303
 * easy
 */
public class RangeSumQuery {
    private int[] preSum;
    public RangeSumQuery(int[] nums){
        preSum = new int[nums.length+1];
        for(int i=1; i<preSum.length; i++){
            preSum[i] = nums[i-1]+preSum[i-1];
        }
    }
    public int sumRange(int left, int right) {
        return preSum[right+1]-preSum[left];
    }

    public static void main(String[] args) {
        int[] preSum = new int[7];
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        for (int i = 0; i<nums.length; i++){
            preSum[i+1] = preSum[i]+nums[i];
        }
        for (int a: preSum){
            System.out.println(a);
        }
    }
}
