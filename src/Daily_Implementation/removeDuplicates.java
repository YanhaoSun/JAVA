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






////2nd
//import java.io.*;
//        import java.util.*;
//        import java.text.*;
//        import java.math.*;
//        import java.util.regex.*;
//
//public class Solution {
//    final static Scanner scan = new Scanner(System.in);
//    final static String fileName = System.getenv("OUTPUT_PATH");
//
//
//    /*
//     * Write the regular expression in the blank space below
//     */
//    final static String regularExpression = "________";
//
//
//    public static void main(String[] args) throws IOException {
//        int query = Integer.parseInt(scan.nextLine());
//        String[] result = new String[query];
//        Arrays.fill(result, "False");
//
//        for (int i = 0; i < query; i++) {
//            String someString = scan.nextLine();
//
//            if (someString.matches(regularExpression)) {
//                result[i] = "True";
//            }
//        }
//
//        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName));
//        for (String res: result) {
//            fileOut.write(res + "\n");
//        }
//
//        fileOut.close();
//    }
//}