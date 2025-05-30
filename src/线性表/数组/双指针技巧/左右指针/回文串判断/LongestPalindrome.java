package 线性表.数组.双指针技巧.左右指针.回文串判断;

public class LongestPalindrome {
    public static String solution(String s) {
        String res = "";
        for (int i=0; i<s.length(); i++){
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            res = res.length()>s1.length()? res:s1;
            res = res.length()>s2.length()? res:s2;
        }
        return res;
    }
    public static String palindrome(String s, int l, int r){
        while (l >= 0 && r<=s.length()-1 && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
