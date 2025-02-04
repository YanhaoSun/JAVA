package array.双指针技巧.快慢指针.滑动窗口;

import java.util.HashMap;

/**
 * 力扣76
 * hard
 */
public class MinWindow {
    public static String solution(String s, String t){
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c: t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (need.size()==valid){
                if (right-left<len){
                    start = left;
                    len = right-left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid --;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE ? "" : s.substring(start, (start+len));
    }
    public static String solutionPrac(String s, String t){
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        for (char c: t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (valid==need.size()){
                if (right-left<len){
                    start = left;
                    len = right-start;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}