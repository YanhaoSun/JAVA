package 线性表.数组.双指针技巧.左右指针.n数之和;

import java.util.Arrays;
import java.util.Stack;

/**
 * 力扣1
 * easy
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
//        Stack<int[]> origin = new Stack<>();
//        for (int i=0; i<nums.length; i++){
//            origin.push(new int[]{nums[i], i});
//        }
//
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length-1;
//        Integer num1 = null, num2 = null;
//        Integer[] result = new Integer[2];
//        while (left<=right){
//            int sum = nums[left]+nums[right];
//            if (sum>target){
//                right--;
//            } else if (sum<target){
//                left++;
//            } else if (sum==target){
//                num1 = nums[left];
//                num2 = nums[right];
//                break;
//            }
//        }
//        if (num1==null && num2==null){
//            return new int[]{};
//        }
//        while (!origin.isEmpty()){
//            int[] tem = origin.pop();
//            if (num1==tem[0] && result[0]==null){
//                result[0] = tem[1];
//            } else if (num2==tem[0] && result[1]==null){
//                result[1] = tem[1];
//            }
//        }
//        return new int[]{result[0], result[1]};
        Stack<int[]> stack = new Stack<>();
        for (int i=0; i<nums.length; i++){
            stack.push(new int[]{nums[i], i});
        }
        Integer[] result = new Integer[2];
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        Integer num1 = null;
        Integer num2 = null;
        while (left<=right){
            int sum = nums[left]+nums[right];
            if (sum==target) {
                num1 = nums[left];
                num2 = nums[right];
                break;
            } else if (sum<target){
                left++;
            } else if (sum>target){
                right--;
            }
        }
        if (num1==null && num2==null){
            return new int[]{};
        }
        while(!stack.isEmpty()){
            int[] temp = stack.pop();
            if (temp[0]==num1 && result[0]==null){
                result[0] = temp[1];
            } else if (temp[0]==num2 && result[1]==null){
                result[1] = temp[1];
            }
        }
        return new int[]{result[0], result[1]};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 4, 3, 0};
        int[] res = twoSum(nums, 0);
        for (int a: res){
            System.out.println(a);
        }
    }
}
