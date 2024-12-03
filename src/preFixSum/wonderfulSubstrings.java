package preFixSum;

import java.util.HashMap;

public class wonderfulSubstrings {
    public static int wonderfulSubstringAlgo(String word){
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int status = 0;
        int res = 0;
        for (int i=0; i<word.length(); i++){
            int index = word.charAt(i)-'a';
            status ^= 1<<index;
            if (freq.containsKey(status)){
                res += freq.get(status);
            }
            for (int j=0; j<10; j++){
                int maskPre = status ^(1<<j);
                if (freq.containsKey(maskPre)){
                    res += freq.get(maskPre);
                }
            }
            if (!freq.containsKey(status)){
                freq.put(status, 1);
            } else {
                freq.put(status, freq.get(status)+1);
            }
        }
        return res;
    }
    public static int wonderfulSubstringAlgo1(String word){
        HashMap<Integer, Integer> dict = new HashMap<>();
        dict.put(0, 1);
        int res = 0;
        int status = 0;
        for (int i=0; i<word.length(); i++){
            int index = word.charAt(i)-'a';
            status ^= 1<<index;
            if (dict.containsKey(status)){
                res += dict.get(status);
            }
            for (int j=0; j<10; j++){
                int maskPre = status ^(1<<j);
                if (dict.containsKey(maskPre)){
                    res += dict.get(maskPre);
                }
            }
            if (!dict.containsKey(status)){
                dict.put(status, 1);
            } else {
                dict.put(status, dict.get(status)+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
