package 线性表.数组.差分数组;

public class RangeAdditionPrac {
    public class difference{
        public int[] difference;
        public difference(int[] nums){
            difference = new int[nums.length];
            difference[0] = nums[0];
            for (int i=1; i<nums.length; i++){
                difference[i] = nums[i]-nums[i-1];
            }
        }
        public void increment(int i, int j, int val){
            difference[i] += val;
            if (j+1<difference.length){
                difference[j+1] -= val;
            }
        }
        public int[] result(){
            int[] res = new int[difference.length];
            res[0] = difference[0];
            for (int i=1; i<difference.length; i++){
                res[i] = res[i-1]+difference[i];
            }
            return res;
        }
    }
}
