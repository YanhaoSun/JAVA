package 线性表.数组.差分数组;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣1109
 * medium
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        difference diff = new difference(nums);
        for (int[] booking: bookings){
            int i = booking[0]-1;
            int j = booking[1]-1;
            int val = booking[2];
            diff.increment(i, j, val);
        }
        return diff.result();
    }
    public static class difference{
        private int[] diff;
        public difference(int[] nums){
            assert nums.length>0;
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i=1; i<nums.length; i++){
                diff[i] = nums[i]-nums[i-1];
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

    /**
     * 解法二
     */
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] bo: bookings){
            insert(bo[0]-1, bo[1]-1, bo[2], diff);
        }
        return diff;
    }
    public void insert(int i, int j, int value, int[] diff){
        for (int m=i; m<=j; m++) {
            diff[m] += value;
        }
    }
    public static void main(String[] args) {

    }
}
