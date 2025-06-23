package 线性表.数组.强化练习数组双指针经典习题;

/**
 * 力扣75
 * medium
 */
public class SortColors {
    // 解法1
    public void sortColors(int[] nums) {
        int index_2 = remove(nums, 2, nums.length);
        int index_1 = remove(nums, 1, index_2);

    }
    public int remove(int[] nums, int a, int bound){
        int index = removeElement(nums, a, bound);
        for (int i=index; i<bound; i++){
            nums[i] = a;
        }
        return index;
    }
    public int removeElement(int[] nums, int a, int bound){
        int slow = 0;
        int fast = 0;
        while (fast<bound){
            if (nums[fast]!=a){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    // 解法2:
    public void sortColors2(int[] nums) {
        int p0 = 0, p = 0, p2 = nums.length-1;
        while (p<=p2){
            if (nums[p]==0){
                swap(nums, p, p0);
                p0++;
            } else if (nums[p]==2){
                swap(nums, p, p2);
                p2--;
            } else if (nums[p]==1){
                p++;
            }
            if (p<p0){
                p = p0;
            }
        }
    }
    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
