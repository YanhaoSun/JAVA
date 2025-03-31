package 线性表.顺序存储结构.Array.双指针技巧.快慢指针.滑动窗口;

import java.util.HashMap;

/**
 * 力扣3
 * medium
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0)+1);
            while (left<s.length() && (window.get(c)>1)){
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d)-1);
            }
            len = Math.max(len, right-left);
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
