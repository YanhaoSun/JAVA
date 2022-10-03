//题目名称: 删除有序数组中的重复项
package Daily_Implementation;

public class removeDuplicates
{
    //使用double pointers
    public int removeDuplicates(int[] nums)
    {
        int slow = 1;
        if(nums.length==0)
        {
            return 0;
        }
        else if(nums.length==1)
        {
            return 1;
        }
        else
        {
            for(int i=1; i<nums.length; i++)
            {
                if(nums[i]!=nums[i-1])
                {
                    nums[slow] = nums[i];
                    slow++;
                }
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        removeDuplicates first = new removeDuplicates();
        int result = first.removeDuplicates(new int[]{1,1,2});
        System.out.println(result);
    }
}
