package 线性表.数组.双指针技巧.左右指针.n数之和;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

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
    public static List<List<Integer>> fourSumRecursion(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget1(nums, 4, 0, target);
//        return nSumTarget(nums, 4, 0, target);
    }
    public static List<List<Integer>> nSumTarget1(int[] nums, int n, int start, long target){
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n<2 || sz<n){
            return res;
        }
        if (n==2){
            int lo = start, hi = sz-1;
            while (lo<hi){
                int sum = nums[lo]+nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum==target){
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo<hi && nums[lo]==left) lo++;
                    while (lo<hi && nums[hi]==right) hi--;
                } else if (sum<target){
                    while (lo<hi && nums[lo]==left) lo++;
                } else if (sum>target){
                    while (lo<hi && nums[hi]==right) hi--;
                }
            }
        } else {
            for (int i=start; i<sz; i++){
                List<List<Integer>> tuples = nSumTarget(nums, n-1, i+1, target-nums[i]);
                for (List<Integer> tuple: tuples){
                    tuple.add(nums[i]);
                    res.add(tuple);
                }
                while (i<sz-1 && nums[i]==nums[i+1]) i++;
            }
        }
        return res;
    }
    public static List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target){
//        int sz = nums.length;
//        List<List<Integer>> res = new ArrayList<>();
//        if (n<2 || sz<n){
//            return res;
//        }
//        if (n==2){
//            int leftInd = start, rightInd = sz-1;
//            while (leftInd<rightInd){
//                int sum = nums[leftInd]+nums[rightInd];
//                int left = nums[leftInd], right = nums[rightInd];
//                if (sum<target){
//                    while (leftInd<rightInd && nums[leftInd]==left) leftInd++;
//                } else if (sum>target){
//                    while (leftInd<rightInd && nums[rightInd]==right) rightInd--;
//                } else {
//                    res.add(new ArrayList<>(Arrays.asList(left, right)));
//                    while (leftInd<rightInd && nums[leftInd]==left) leftInd++;
//                    while (leftInd<rightInd && nums[rightInd]==right) rightInd--;
//                }
//            }
//        } else {
//            for (int i=start; i<sz; i++){
//                List<List<Integer>> sub = nSumTarget(nums, n-1, i+1, target-nums[i]);
//                for (List<Integer> arr: sub){
//                    arr.add(nums[i]);
//                    res.add(arr);
//                }
//                while (i<sz-1 && nums[i]==nums[i+1]) i++;
//            }
//        }
//        return res;
        int sz = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n<2 || sz<n){
            return result;
        }
        if (n==2){
            int left = start, right = sz-1;
            while (left<right){
                int sum = nums[left]+nums[right];
                int numLeft = nums[left], numRight = nums[right];
                if (sum==target){
                    result.add(new ArrayList<>(Arrays.asList(numLeft, numRight)));
                    while (left<right && nums[left]==numLeft) left++;
                    while (left<right && nums[right]==numRight) right--;
                } else if (sum<target){
                    while (left<right && nums[left]==numLeft) left++;
                } else if (sum>target){
                    while (left<right && nums[right]==numRight) right--;
                }
            }
        } else {
            for (int i=start; i<sz; i++){
                List<List<Integer>> tuples = nSumTarget(nums, n-1, i+1, target-nums[i]);
                for (List<Integer> tuple: tuples){
                    tuple.add(nums[i]);
                    result.add(tuple);
                }
                while (i<sz-1 && nums[i]==nums[i+1]) i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> fourSumRecursion = fourSumRecursion(nums, -294967296);
        if (fourSumRecursion.size()==0){
            System.out.println("true");
        }
        for (List<Integer> tuple: fourSumRecursion){
            System.out.println(tuple);
        }
        String[] a = new String[2];
        String.join(" ", a);
//        Character.to
    }
}
