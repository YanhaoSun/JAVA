package array;

public class ChangDuZuiXiaoShuZu {

    /**
     * 注意: 再解这道题的时候，要注意 逐渐求和窗口的右边的确可以找出比 s 大的，
     * 但是也要注意在窗口的右边不变的情况下也要缩小窗口的左边，看是否能找到长度更小的满足 s 的数组
     * 这就是 while (sum >= s) 的作用
     * @param array
     * @param s
     * @return
     */
    public static int slideWindowFindMinLengthArray(int[] array, int s){
        int left = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int i=0; i<array.length; i++){
            sum += array[i];
            while (sum>=s){
                result = Math.min(result, i-left+1);
                sum -= array[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0:result;
    }




    //滑动窗口解法
    public static int minSubArrayLen1(int target, int[] nums)
    {
        int left=0;
        int sum=0;
        int result = Integer.MAX_VALUE;
        boolean exist = false;
        for(int right=0; right<nums.length; right++)
        {
            sum += nums[right];
            while(sum>=target)
            {
                result = Math.min(result, (right-left+1));
                sum -= nums[left++];
                exist = true;
            }
        }
        if(exist)
        {
            return result;
        }
        else
        {
            return 0;
        }
    }

    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,2,3,4,5,5,1,1};
        System.out.println("min = "+ ChangDuZuiXiaoShuZu.slideWindowFindMinLengthArray(nums, target));
    }
}
