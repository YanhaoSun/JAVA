package Daily_Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*Write a function that takes an array of numbers (integers for the tests) and a target number.
It should find two different items in the array that, when added together, give the target value.
The indices of these items should then be returned in a tuple / list (depending on your language) like so: (index1, index2).
For the purposes of this kata, some tests may have multiple answers; any valid solutions will be accepted.
The input will always be valid (numbers will be an array of length 2 or greater
and all of the items will be numbers; target will always be the sum of two different items from that array).*/
public class TwoSum
{
    public static int[] twoSum(int[] numbers, int target)
    {
        int[] result;
        ArrayList<Integer> rr = new ArrayList<>();
        for(int i=0; i<numbers.length; i++)
        {
            int store = target-numbers[i];
            for(int m=i+1; m<numbers.length; m++)
            {
                if(store==numbers[m])
                {
                    rr.add(i);
                    rr.add(m);
                }
            }
        }
        result = rr.stream().mapToInt(i -> i).toArray();
//        System.out.println("length = "+result.length);
        return result; // Do your magic!
    }

    //使用 hashtable to implement
    public int[] twoSum_Hashtable(int[] nums, int target)
    {
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++)
        {
            if(store.containsKey(target-nums[i]))
            {
                result[0] = store.get(target-nums[i]);
                result[1] = i;
            }
            store.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] first = twoSum(new int[]{1, 2, 3}, 4);
        for(int a: first)
        {
            System.out.print(a);
        }
        System.out.println();
        int[] second = twoSum(new int[]{3,2,4}, 6);
        for(int a: second)
        {
            System.out.print(a);
        }
    }
}
