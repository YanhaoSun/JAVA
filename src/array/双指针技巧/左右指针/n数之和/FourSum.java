package array.双指针技巧.左右指针.n数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 力扣18
 * medium
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i=0; i<n; i++){
            List<List<Integer>> triples = threeSum(nums, i+1, target-nums[i]);
            for (List<Integer> triple: triples){
                triple.add(nums[i]);
                res.add(triple);
            }
            while (i<n-1 && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums, int start, long target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i=start; i<n; i++){
            List<List<Integer>> tuples = twoSum(nums, i+1, target-nums[i]);
            for (List<Integer> tuple: tuples){
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i<n-1 && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, int start, long target) {
        int leftInd = start, rightInd = nums.length-1;
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

    /**
     * 使用递归
     */
    public static List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target){
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n<2 || sz<n){
            return res;
        }
        if (n==2){
            int leftInd = start, rightInd = sz-1;
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
        } else {
            for (int i=start; i<sz; i++){
                List<List<Integer>> sub = nSumTarget(nums, n-1, i+1, target-nums[i]);
                for (List<Integer> arr: sub){
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i<sz-1 && nums[i]==nums[i+1]) i++;
            }
        }
        return res;
    }
}
