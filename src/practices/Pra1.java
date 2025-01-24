package practices;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.Scanner;

public class Pra1 {


        public static int MathChallenge(int num) {
            char[] digits = String.valueOf(num).toCharArray();
            int n = digits.length;

            // Step 1: 从右向左找到第一个违反升序规则的数字
            int i = n - 2;
            while (i >= 0 && digits[i] >= digits[i + 1]) {
                i--;
            }

            // 如果没找到，说明已经是最大排列
            if (i < 0) {
                return -1;
            }

            // Step 2: 从右向左找到比 digits[i] 大的最小数字
            int j = n - 1;
            while (digits[j] <= digits[i]) {
                j--;
            }

            // Step 3: 交换 digits[i] 和 digits[j]
            char temp = digits[i];
            digits[i] = digits[j];
            digits[j] = temp;

            // Step 4: 反转 i+1 到末尾的数字
            reverse(digits, i + 1, n - 1);
//            int result = Integer.parseInt(new String(digits));
//            String token = "ih903y7lb";
//            String resultString = String.valueOf(result);
//            for (char ch : token.toCharArray()){
//                resultString = resultString.replace(String.valueOf(ch), "--"+ch+"--");
//            }
//            return Integer.parseInt(resultString);

            // 转回整数
            return Integer.parseInt(new String(digits));
        }

        // 辅助方法：反转字符数组的一部分
        private static void reverse(char[] arr, int start, int end) {
            while (start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        public static void main(String[] args) {
            // 读取输入并调用方法
            Scanner s = new Scanner(System.in);
            System.out.println("Enter a number:");
            int num = s.nextInt();
            int result = MathChallenge(num);
            System.out.println("Output: " + result);

            // 根据 ChallengeToken 替换字符
            String token = "ih903y7lb";
            String resultStr = String.valueOf(result);
            for (char ch : token.toCharArray()) {
                resultStr = resultStr.replace(String.valueOf(ch), "--" + ch + "--");
            }
            System.out.println("Final Output: " + resultStr);
        }
}
