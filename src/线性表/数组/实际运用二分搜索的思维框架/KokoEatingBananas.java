package 线性表.数组.实际运用二分搜索的思维框架;

/**
 * 力扣875
 * medium
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;
        while (left<=right){
            int mid = left+(right-left)/2;
            long hours = timeNeed(piles, mid);
            if (hours==h){
                right = mid-1;
            } else if (hours<h){
                right = mid-1;
            } else if (hours>h){
                left = mid+1;
            }
        }
        return left;
    }
    public long timeNeed(int[] piles, int speed){
        long hours = 0;
        for (int i=0; i<piles.length; i++){
            hours += piles[i]/speed;
            if (piles[i]%speed>0){
                hours ++;
            }
        }
        return hours;
    }
}
