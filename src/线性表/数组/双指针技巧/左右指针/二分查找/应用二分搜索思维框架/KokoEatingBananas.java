package 线性表.顺序存储结构.Array.双指针技巧.左右指针.二分查找.应用二分搜索思维框架;

/**
 * 力扣875
 * medium
 */
public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (hoursRequired(piles, mid)>h){
                left = mid+1;
            } else if (hoursRequired(piles, mid)<=h){
                right = mid-1;
            }
        }
        return left;
    }
    public static long hoursRequired(int[] piles, long x){
        long hours = 0;
        for (int i=0; i<piles.length; i++){
            hours += piles[i]/x;
            if (piles[i]%x>0){
                hours ++;
            }
        }
        return hours;
    }
    public static void main(String[] args) {
        System.out.println(33/10);
    }
}
