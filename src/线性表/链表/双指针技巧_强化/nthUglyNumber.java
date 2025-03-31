package 线性表.linkedList.双指针技巧_强化;


import list.ListNode;

/**
 * 力扣第 264 题「丑数 II
 * medium
 */
public class nthUglyNumber {
    public static int solution(int n){
        int p2 = 1, p3 = 1, p5 = 1;
        int product2 = 1, product3 = 1, product5 = 1;
        int[] uglyNum = new int[n+1];
        int p = 1;

        while (p<=n){
            int min = Math.min(Math.min(product2, product3), product5);
            uglyNum[p] = min;
            p++;
            if (min==product2){
                product2 = 2*uglyNum[p2];
                p2++;
            }
            if (min==product3){
                product3 = 3*uglyNum[p3];
                p3++;
            }
            if (min==product5){
                product5 = 5*uglyNum[p5];
                p5++;
            }
        }
        return uglyNum[n];
    }
}
