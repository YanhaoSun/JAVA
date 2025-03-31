package 线性表.数组.差分数组;

/**
 * 力扣1094
 * medium
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        difference diff = new difference(nums, capacity);
        for (int[] trip: trips){
            int i = trip[1];
            int j = trip[2];
            int val = trip[0];
            diff.increment(i, j, val);
        }
        return diff.result();
    }
    public static class difference{
        int[] diff;
        int capacity = 0;
        public difference(int[] nums, int capacity){
            assert nums.length>0;
            this.capacity = capacity;
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
        public boolean result(){
            int[] res = new int[diff.length];
            res[0] = diff[0];
            if (res[0]>capacity){
                return false;
            }
            for (int i=1; i<res.length; i++){
                res[i] = res[i-1]+diff[i];
                if (res[i]>capacity){
                    return false;
                }
            }
            return true;
        }
    }
}
