package 线性表.顺序存储结构.Array.双指针技巧.左右指针.n数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSumTarget(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<n; i++){
            List<List<Integer>> tuples = twoSumTarget(nums, i+1, target-nums[i]);
            for (List<Integer> tuple: tuples){
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i<n-1 && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
    public static List<List<Integer>> twoSumTarget(int[] nums, int start, int target){
        Arrays.sort(nums);
        int leftInd = start;
        int rightInd = nums.length-1;
        List<List<Integer>> res = new ArrayList<>();
        while (leftInd<rightInd){
            int sum = nums[leftInd]+nums[rightInd];
            int left = nums[leftInd], right = nums[rightInd];
            if (sum<target){
                while (leftInd<rightInd && nums[leftInd]==left) leftInd++;
            } else if (sum>target) {
                while (leftInd < rightInd && nums[rightInd] == right) rightInd--;
            } else {
                res.add(new ArrayList<>(Arrays.asList(left, right)));
                while (leftInd<rightInd && nums[leftInd]==left) leftInd++;
                while (leftInd<rightInd && nums[rightInd]==right) rightInd--;
            }
        }
        return res;
    }


    public static List<List<Integer>> threeSumTargetPrac(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<n; i++){
            List<List<Integer>> tuples = twoSumTargetPrac(nums, i+1, target-nums[i]);
            for (List<Integer> tuple: tuples){
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i<n-1 && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
    public static List<List<Integer>> twoSumTargetPrac(int[] nums, int start, int target){
        int leftInd = 0, rightInd = nums.length-1;
        List<List<Integer>> res = new ArrayList<>();
        while (leftInd<rightInd){
            int sum = nums[leftInd]+nums[rightInd];
            int left = nums[leftInd], right = nums[rightInd];
            if (sum<target){
                while (leftInd<rightInd && nums[leftInd]==left) leftInd++;
            } else if (sum>target){
                while (leftInd<rightInd && nums[rightInd]==right) rightInd--;
            } else {
                res.add(new ArrayList<>(Arrays.asList(left, right)));
                while (leftInd<rightInd && nums[leftInd]==left) leftInd++;
                while (leftInd<rightInd && nums[rightInd]==right) rightInd--;
            }
        }
        return res;
    }
}
