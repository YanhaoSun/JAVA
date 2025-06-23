package practices;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pra1 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference difference = new Difference(nums);
        for (int[] update: updates){
            int i = update[0];
            int j = update[1];
            int val = update[2];
            difference.increment(i, j, val);
        }
        return difference.result();
    }
    public class Difference{
        int[] diff;
        public Difference(int[] nums){
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i=1; i<nums.length; i++){
                diff[i] = nums[i] - nums[i-1];
            }
        }
        public void increment(int i, int j, int val){
            diff[i] += val;
            if (j+1<diff.length){
                diff[j+1] -= val;
            }
        }
        public int[] result(){
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i=1; i<diff.length; i++){
                res[i] = res[i-1]+diff[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
    }
}
