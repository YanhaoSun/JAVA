package doublePointers.DollidingPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class threeSum {
    public static List<List<Integer>> threeSumAlgo(List<Integer> list){
        list.sort((a, b) -> Integer.compare(a, b));
        int left = 0;
        int right = 0;
        int l = list.size();
        List<List<Integer>> result = new ArrayList<>();
        if (list.size()<3){
            return result;
        }
        for (int i=0; i<list.size()-1; i++){
            left = i+1;
            right = l-1;
            if (list.get(i)>0) return result;
            if (i>0 && (Objects.equals(list.get(i), list.get(i - 1)))) continue;
            while (left < right){
                if ((list.get(i)+list.get(left)+list.get(right))==0){
                    List<Integer> triple = new ArrayList<>();
                    triple.add(list.get(i));
                    triple.add(list.get(left));
                    triple.add(list.get(right));
                    result.add(triple);
                    while (left<right && (list.get(left)==list.get(left+1))){
                        left++;
                    }
                    while (left<right && (list.get(right)==list.get(right-1))){
                        right--;
                    }
                    left++;
                    right--;
                } else if ((list.get(i)+list.get(left)+list.get(right))>0){
                    right--;
                } else {
//                    System.out.println("here");
//                    System.out.println((list.get(i)+list.get(left)+list.get(right)));
                    left++;
                }
            }
        }
        return result;
    }
    public static List<List<Integer>> threeSumAlgo1(List<Integer> list){
        list.sort((a, b) -> Integer.compare(a, b));
        int left = 0;
        int right = list.size()-1;
        List<List<Integer>> result = new ArrayList<>();
        if (list.size()<3){
            return result;
        }
        for (int i = 0; i<list.size()-1; i++){
            left = i+1;
            right = list.size()-1;
            if (list.get(i)>0) return result;
            if (i>0 && (list.get(i)==list.get(i-1))) continue;
            while (left<right){
                int sum = list.get(i)+list.get(left)+list.get(right);
                if (sum==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(list.get(i));
                    temp.add(list.get(left));
                    temp.add(list.get(right));
                    result.add(temp);
                    while (left<right && (list.get(left)==list.get(left+1))){
                        left++;
                    }
                    while (left<right && (list.get(right)==list.get(right-1))){
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum>0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
    public static List<List<Integer>> threeSumAlgo2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int left =  0;
        int right = nums.length-1;
        if (nums.length<3){
            return result;
        }
        for (int i=0; i<nums.length-1; i++){
            if (nums[i]>0){
                return result;
            }
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            left = i+1;
            right = nums.length-1;
            while (left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if (sum==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while (left<right && (nums[left]==nums[left+1])){
                        left++;
                    }
                    while (left<right && (nums[right]==nums[right-1])){
                        right--;
                    }
                    right--;
                    left++;
                } else if (sum>0){
                    right--;
                } else {
                    left++;
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

        List<Integer> input1 = new ArrayList<>();
        input1.add(-1);
        input1.add(0);
        input1.add(1);
        input1.add(2);
        input1.add(-1);
        input1.add(-4);
//        for(List<Integer> val: threeSumAlgo(input)){
//            System.out.println(val);
//        }
        System.out.println();
//        for(List<Integer> val: threeSumAlgo1(input1)){
//            System.out.println(val);
//        }
        int[] nums1 = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for(List<Integer> val: threeSumAlgo2(nums)){
            System.out.println(val);
        }
        System.out.println();
    }
}