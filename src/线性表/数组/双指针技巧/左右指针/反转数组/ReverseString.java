package 线性表.数组.双指针技巧.左右指针.反转数组;

/**
 * 力扣344
 * easy
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
