package 线性表.数组.强化练习数组双指针经典习题;

/**
 * 力扣977
 * easy
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        int i = right;
        while (left<=right){
            int l = nums[left];
            int r = nums[right];
            l = l*l;
            r = r*r;
            if (l>r){
                res[i] = l;
                left++;
                i--;
            } else {
                res[i] = r;
                right--;
                i--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println((-1*-1));
    }
}
