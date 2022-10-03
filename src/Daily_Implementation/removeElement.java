//题目: 移除元素
package Daily_Implementation;

public class removeElement
{
    public int removeElements(int[] nums, int val)
    {
        int slow = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]!=val)
            {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        removeElement first = new removeElement();
        int result = first.removeElements(new int[]{0,1,2,2,3,0,4,2}, 2);
        System.out.println("result = "+result);

    }
}
