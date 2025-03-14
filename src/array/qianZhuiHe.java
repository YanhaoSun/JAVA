package array;

import java.util.Arrays;

public class qianZhuiHe {
        public static int findTheLongestSubstring(String s) {
            int n = s.length();
            int[] pos = new int[1 << 5];
            Arrays.fill(pos, -1);
            int ans = 0, status = 0;
            pos[0] = 0;
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'a') {
                    status ^= (1 << 0);
                } else if (ch == 'e') {
                    status ^= (1 << 1);
                } else if (ch == 'i') {
                    status ^= (1 << 2);
                } else if (ch == 'o') {
                    status ^= (1 << 3);
                } else if (ch == 'u') {
                    status ^= (1 << 4);
                }
                if (pos[status] >= 0) {
                    ans = Math.max(ans, i + 1 - pos[status]);
                } else {
                    pos[status] = i + 1;
                }
            }
            return ans;
    }

    public static void main(String[] args) {
        String s = "perhaeiiaoouuheeeeeeeee";
        int result = findTheLongestSubstring(s);
        System.out.println(result);
    }
}
