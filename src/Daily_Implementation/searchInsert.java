package Daily_Implementation;

public class searchInsert
{
    //二分法 yyds (但是这个有点蠢)
    public int ssearchInsert(int[] nums, int target) {
        int mid = (nums.length-1)/2;
        boolean find = false;
        int left = 0;
        int right = nums.length-1;
        while (!find)
        {
            System.out.println("mid = "+mid);

            if(nums[mid]==target)
            {
                return mid;
            }
            if(target<nums[0])
            {
                return 0;
            }
            if(target>nums[nums.length-1])
            {
                return nums.length;
            }
            if(nums[mid]<target && target<nums[mid+1])
            {
                return mid+1;
            }
            if(target<nums[mid] && nums[mid-1]<target)
            {
                return mid;
            }
            if(nums[mid]<target)
            {
                left = mid+1;
                mid = (left+right)/2;
            }
            if(nums[mid]>target)
            {
                right = mid-1;
                mid = (left+right)/2;
            }
        }
        return 0;
    }

    //二分法 yyds (这个聪明)
    public int sssearchInsert(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length-1;
        int ans = 0;
        while(left<=right)
        {
            int mid = ((right-left)>>1) + left;
            if(target<nums[0])
            {
                ans = 0;
                break;
            }
            if(target>nums[nums.length-1])
            {
                ans = nums.length;
                break;
            }
            if(target<=nums[mid])
            {
                ans = mid;
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        searchInsert first = new searchInsert();
        int First_result_1 = first.ssearchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println("First_result_1 = "+First_result_1);

        int First_result_2 = first.ssearchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println("First_result_2 = "+First_result_2);

        int First_result_3 = first.ssearchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println("First_result_3 = "+First_result_3);

        int First_result_4 = first.ssearchInsert(new int[]{1}, 1);
        System.out.println("First_result_4 = "+First_result_4);

        int First_result_5 = first.ssearchInsert(new int[]{1, 3}, 3);
        System.out.println("First_result_5 = "+First_result_5);



        int Second_result_1 = first.sssearchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println("Second_result_1 = "+Second_result_1);

        int Second_result_2 = first.sssearchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println("Second_result_2 = "+Second_result_2);

        int Second_result_3 = first.sssearchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println("Second_result_3 = "+Second_result_3);

        int Second_result_4 = first.sssearchInsert(new int[]{1}, 1);
        System.out.println("Second_result_4 = "+Second_result_4);

        int Second_result_5 = first.sssearchInsert(new int[]{1, 3}, 3);
        System.out.println("Second_result_5 = "+Second_result_5);

        int Second_result_6 = first.sssearchInsert(new int[]{1, 3}, 2);
        System.out.println("Second_result_6 = "+Second_result_6);
    }
}
