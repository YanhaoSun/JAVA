package 线性表.数组.强化练习数组双指针经典习题;

/**
 * 力扣125
 * easy
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()){
            if (Character.isLetterOrDigit(ch)){
                sb.append(Character.valueOf(Character.toLowerCase(ch)));
            }
        }
        int left = 0;
        int right = sb.length()-1;
        while (left<right){
            if (sb.charAt(left)!=sb.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
    }
}
