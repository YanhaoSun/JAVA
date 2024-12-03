package Daily_Implementation;

public class pivotIndex
{//1 7 3 6 5 6
    //每当loop到一个数时, 计算i左边之和, 再计算右边之和, 再做比较, 就比较麻烦
    public int ppivotIndex(int[] nums) {
        if(nums.length==0)
        {
            return -1;
        }
        int pivot = 0;
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i<nums.length; i++)
        {
            pivot = i;
            leftSum = 0;
            rightSum = 0;
            if(i!=0)
            {
                for(int j = 0; j<pivot; j++)
                {
                    leftSum += nums[j];
                }
            } else
            {
                leftSum = 0;
            }

            if(i!=nums.length-1)
            {
                for(int j = pivot+1; j<nums.length; j++)
                {
                    rightSum += nums[j];
                }
            } else
            {
                rightSum = 0;
            }

            if(leftSum==rightSum)
            {
                break;
            }
        }
        if(leftSum!=rightSum)
        {
            return -1;
        }
        return pivot;
    }

    //简单解答:
    //所有elements之和记作total, i左边的elements之和记作leftSum,
    //我们可以得知: total = leftSum+num[i]+leftSum, 因为只有当左右两边相等的时候i才是pivot
    //所以当total = 2leftSum+num[i]时, i是pivot
    public int ppivotIndex_Sec(int[] nums) {
        if(nums.length==0)
        {
            return -1;
        }
        int total = 0;
        for(int i: nums)
        {
            total += i;
        }
        int pivot = 0;
        int leftSum = 0;
        for(int i = 0; i<nums.length; i++)
        {
            pivot = i;
            if(i!=0)
            {
                leftSum += nums[i-1];
            } else
            {
                leftSum = 0;
            }
            if((2*leftSum)+nums[i]==total)
            {
                break;
            }
            else if((2*leftSum)+nums[i]!=total && i==nums.length-1)
            {
                pivot = -1;
                break;
            }
        }
        return pivot;
    }
    public static void main(String[] args) {
        pivotIndex first = new pivotIndex();
//        int result = first.ppivotIndex(new int[]{1,7,3,6,5,6});
//        System.out.println("first result = "+result);
//
//        int resultSec = first.ppivotIndex(new int[]{1, 2, 3});
//        System.out.println("second result = "+resultSec);
//
//        int resultThd = first.ppivotIndex(new int[]{2, 1, -1});
//        System.out.println("third result = "+resultThd);

        int result1 = first.ppivotIndex_Sec(new int[]{1,7,3,6,5,6});
        System.out.println("first result = "+result1);

        int resultSec2 = first.ppivotIndex(new int[]{1, 2, 3});
        System.out.println("second result = "+resultSec2);

        int resultThd3 = first.ppivotIndex(new int[]{2, 1, -1});
        System.out.println("third result = "+resultThd3);
    }
}
