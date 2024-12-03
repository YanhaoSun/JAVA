package array;

public class YiChuYuanSu
{
    public int removeEle1(int[] nums, int val) {
        boolean quit;
        int j;
        int result = 9;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==val && i!=nums.length-1)
            {
                System.out.println("get in, nums[i] = "+nums[i]+" and i = "+i);
                j = i+1;
                quit = false;
                while (!quit)
                {
                    System.out.println("count");
                    int temp;
                    if(nums[i]!=nums[j])
                    {
                        //switch
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        quit = true;
                    }
                    else if(nums[i]==nums[j] && j!=nums.length-1)
                    {
                        j++;
                    }
                    else
                    {
                        quit = true;
                        result = i;
                    }
                    System.out.println("nums[i] = "+nums[i]+"\n");
                }
            }
            else if(nums[i]==val && i==nums.length-1)
            {
                result = i;
            }
        }
        return result;
    }


    public int removeElem(int[] nums, int val){
        int slow = 0;
        for(int fast = 0; fast<nums.length; fast++){
            if(nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }






    //双指针法
    public int removeEle(int[] nums, int val)
    {
        int count = 0;
        for(int num: nums)
        {
            if(num!=val)
            {
                nums[count] = num;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,2,2,3};
        int val1 = 3;
        YiChuYuanSu test1 = new YiChuYuanSu();
        int result1 = test1.removeEle(nums1, val1);
        System.out.println("result1 = "+result1+"\n");

        int[] nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 3;
        YiChuYuanSu test2 = new YiChuYuanSu();
        int result2 = test2.removeEle(nums2, val2);
        System.out.println("result2 = "+result2);
    }
}

//    int slow = 0;
//        for(int i=0; i<nums.length; i++)
//        {
//        if(nums[i]!=val)
//        {
//        nums[slow] = nums[i];
//        slow++;
//        }
//        }
//        return slow;