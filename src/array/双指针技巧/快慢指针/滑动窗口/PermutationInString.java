package array.双指针技巧.快慢指针.滑动窗口;

import java.util.HashMap;

/**
 * 力扣 567
 * medium
 */
public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        int left = 0;
        int right = 0;
        for (char c: s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int valid = 0;
        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (right-left>=s1.length()){
                char d = s2.charAt(left);
                if (valid==need.size()){
                    return true;
                }
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
                left++;
            }
        }
        return false;
    }
    public static boolean checkInclusionPrac(String s1, String s2){
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        for (char c: s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        while (right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (right-left>=s1.length()){
                if (valid==need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return false;
    }
}
