package array;

import java.util.Scanner;

public class intervalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("n = "+n);
        int[] vec = new int[n];
        int[] p = new int[n];
        int preSum = 0;

        for (int i=0; i<n; i++){
            vec[i] = scanner.nextInt();
            System.out.println("vec["+i+"] = "+vec[i]);
            preSum += vec[i];
            p[i] = preSum;
        }

        while (scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("a, b = "+a+b);
            int sum;
            if (a==0){
                sum = p[b];
            } else {
                sum = p[b] - p[a-1];
            }
            System.out.println("result = "+sum);
            break;
        }
        scanner.close();
    }
}
