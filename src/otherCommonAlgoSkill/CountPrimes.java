package otherCommonAlgoSkill;

import java.util.Arrays;

/**
 * 力扣第 204 题「计算质数
 * medium
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i=2; i*i<n; i++){
            if (isPrimes[i]){
                for (int j=i*i; j<n; j+=i){
                    isPrimes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i=2; i<n; i++){
            if (isPrimes[i]) count++;
        }
        return count;
    }
    public static int countPrimePrac(int n){
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i=2; i*i<n; i++){
            if (isPrimes[i]){
                for (int j=i*i; j<n; j+=i){
                    isPrimes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i=2; i<n; i++){
            if (isPrimes[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

}
