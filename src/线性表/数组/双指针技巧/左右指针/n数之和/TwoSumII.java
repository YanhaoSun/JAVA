package 线性表.数组.双指针技巧.左右指针.n数之和;

/**
 * 力扣167
 * medium
 */
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] result = new int[2];
        while (left<=right){
            int sum = numbers[left]+numbers[right];
            if (sum>target){
                right--;
            } else if (sum<target){
                left++;
            } else if (sum==target){
                result[0] = left+1;
                result[1] = right+1;
                return result;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4};
        int[] re = twoSum(a, 6);
        for (int b: re){
            System.out.println(b);
        }
    }
}
