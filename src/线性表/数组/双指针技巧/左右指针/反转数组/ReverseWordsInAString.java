package 线性表.数组.双指针技巧.左右指针.反转数组;

import java.util.StringTokenizer;

public class ReverseWordsInAString {
    /**
     * 使用 StringTokenizer
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        // 用StringTokenizer去掉String中的空格
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        String[] words = new String[stringTokenizer.countTokens()];
        int index = 0;

        // 去掉空格以后, 对每个单词进行reverse
        while (stringTokenizer.hasMoreTokens()){
            words[index++] = reverseString(stringTokenizer.nextToken());
        }

        // 对每个单词reverse以后再用" "连接起来成为一个字符串
        String result = String.join(" ", words);

        // 再对连接起来的字符串进行reverse
        return reverseString(result);
    }

    /**
     * 使用Trim, Split和正则表达式
     * @param s
     * @return
     */
    public static String reverseWordsWithTrimAndSplit(String s) {
        String[] words = s.trim().split("\\s+");
        for (int i=0; i<words.length; i++){
            words[i] = reverseString(words[i]);
        }
        String result = String.join(" ", words);
        return reverseString(result);
    }
    public static String reverseString(String s){
        char[] word = s.toCharArray();
        int left = 0;
        int right = word.length-1;
        while (left < right){
            char temp = word[left];
            word[left] = word[right];
            word[right] = temp;
            left++;
            right--;
        }
//        return new String(word);
        return String.valueOf(word);
    }

    public static void main(String[] args) {
        String s = "  hello   world  ";
        reverseWords(s);
    }
}
