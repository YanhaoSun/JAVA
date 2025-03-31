package 线性表.数组.差分数组;

/**
 * 力扣370
 * medium
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates){
        int[] nums = new int[length];
        difference diff = new difference(nums);
        for (int[] update: updates){
            int i = update[0];
            int j = update[1];
            int val = update[2];
            diff.increment(i, j, val);
        }
        return diff.result();
    }
    public class difference{
        private int[] diff;
        public difference(int[] nums){
            assert nums.length>0;
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i=1; i<diff.length; i++){
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
}
