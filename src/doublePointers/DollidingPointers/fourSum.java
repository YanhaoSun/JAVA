package doublePointers.DollidingPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static List<List<Integer>> fourSumAlgo(List<Integer> list, int target){
        list.sort((a, b) -> Integer.compare(a, b));
        int l = list.size();
        int left = 0;
        int right = 0;
        List<List<Integer>> result = new ArrayList<>();
        if (list.size()<4) return result;
        for (int i=0; i<list.size(); i++){
            if (i>0 && (list.get(i)==list.get(i-1))) continue;
            for (int j=i+1; j<list.size(); j++){
                if (j>0 && (list.get(j)==list.get(j-1))) continue;
                left = j+1;
                right = l-1;
                while (left<right){
                    int sum = list.get(i)+list.get(j)+list.get(left)+list.get(right);
                    if (sum==target){
                        List<Integer> quadra = new ArrayList<>();
                        quadra.add(list.get(i));
                        quadra.add(list.get(j));
                        quadra.add(list.get(left));
                        quadra.add(list.get(right));
                        result.add(quadra);
                        while (left<right && (list.get(left)==list.get(left+1))){
                            left++;
                        }
                        while (left<right && (list.get(right)==list.get(right-1))){
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > target){
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSumAlgo1(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length<4) return result;
        for (int i=0; i<nums.length; i++){
            if (i>0 && (nums[i]==nums[i-1])) continue;
            for (int j=i+1; j<nums.length; j++){
                if (j>i+1 && (nums[j]==nums[j-1])) continue;
                left = j+1;
                right = nums.length-1;
                while (left < right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum==target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        result.add(temp);
                        while (left < right && (nums[left]==nums[left+1])){
                            left++;
                        }
                        while (left < right && (nums[right]==nums[right-1])){
                            right--;
                        }
                        left ++;
                        right --;
                    } else if(sum>target){
                        right --;
                    } else{
                        left ++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(-2);
        input.add(-2);
        input.add(-1);
        input.add(-5);
        input.add(-8);
        input.add(1);
        input.add(3);
        input.add(2);
        input.add(7);
        input.add(10);
        input.add(12);
        input.add(11);
        input.add(6);
        input.add(14);
        input.add(19);
        for(List<Integer> val: fourSumAlgo(input, -1)){
//            System.out.println(val);
        }


        int[] input1 = new int[]{1000000000,1000000000,1000000000,1000000000};
        for(List<Integer> val: fourSumAlgo1(input1, -294967296)){
            System.out.println(val);
        }
        long sum = 0;
        for (int val: input1){
            sum += val;
        }
        System.out.println("val = "+sum);
//        Arrays.copyOfRange()
    }
}
