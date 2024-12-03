package array;

public class elementRemoval {
    public int remove(int[] nums, int val){
        int slowIndex = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=val){
                nums[slowIndex] = nums[i];
                slowIndex ++;
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        elementRemoval test1 = new elementRemoval();
        int result = test1.remove(nums, val);
        System.out.println("result = "+result);
    }
}
