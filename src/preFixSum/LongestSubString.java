package preFixSum;

import java.util.Arrays;

public class LongestSubString {
    public static int findTheLongestSubstring(String s){
        int[] posDict = new int[1<<5];
        Arrays.fill(posDict, -1);
        posDict[0] = 0;
        int status = 0;
        int res = 0;
        for (int i=0; i<s.length(); i++){
            char letter = s.charAt(i);
            switch (letter){
                case 'a':
                    status ^= 1<<0;
                    break;
                case 'e':
                    status ^= 1<<1;
                    break;
                case 'i':
                    status ^= 1<<2;
                    break;
                case 'o':
                    status ^= 1<<3;
                    break;
                case 'u':
                    status ^= 1<<4;
                    break;
            }
            if (posDict[status]!=-1){
                res = Math.max(res, i+1-posDict[status]);
            } else {
                posDict[status] = i+1;
            }
        }
        return res;
    }


    public static int findTheLongestSubstring1(String s){
        int[] posDict = new int[1<<5];
        Arrays.fill(posDict, -1);
        int status = 0;
        posDict[0] = 0;
        int res = 0;
        for (int i=0; i<s.length(); i++){
            char letter = s.charAt(i);
            switch (letter){
                case 'a':
                    status ^= 1<<0;
                    break;
                case 'e':
                    status ^= 1<<1;
                    break;
                case 'i':
                    status ^= 1<<2;
                    break;
                case 'o':
                    status ^= 1<<3;
                    break;
                case 'u':
                    status ^= 1<<4;
                    break;
            }
            if (posDict[status]!=-1){
                res = Math.max(res, i+1-posDict[status]);
            } else {
                posDict[status] = i+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "perhaeiiaoouuheeee";
//        int result = findTheLongestSubstring(s);
//        System.out.println(result);

        int result1 = findTheLongestSubstring1(s);
        System.out.println(result1);
    }
}
