package 线性表.顺序存储结构.Array.双指针技巧.快慢指针.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 力扣438
 * medium
 */
public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int right = 0;
        int left = 0;
        int valid = 0;
        for (char c: p.toCharArray()){
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
            while (right-left>=p.length()){
                if (valid==need.size()){
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return result;
    }
    public static List<Integer> findAnagramsPrac(String s, String p){
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> result = new ArrayList<>();
        for (char c: p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (right-left>=p.length()){
                char d = s.charAt(left);
                if (valid==need.size()){
                    result.add(left);
                }
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return result;
    }
}
