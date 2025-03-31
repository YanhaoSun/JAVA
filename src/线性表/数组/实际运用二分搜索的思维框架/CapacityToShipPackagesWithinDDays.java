package 线性表.数组.实际运用二分搜索的思维框架;

/**
 * 力扣1011
 * medium
 */
public class CapacityToShipPackagesWithinDDays {
    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
// f(x) 随着 x 的增加单调递减
    public int shipWithinDays(int[] weights, int days) {
        int left = 1, right = 0;
        for (int w: weights){
            left = Math.max(left, w);
            right += w;
        }
        while (left<=right){
            int mid = left+(right-left)/2;
            long daysNeed = daysNeed(weights, mid);
            if (daysNeed==days){
                right = mid-1;
            } else if (daysNeed<days){
                right = mid-1;
            } else if (daysNeed>days){
                left = mid+1;
            }
        }
        return left;
    }
    public long daysNeed(int[] weights, int cap){
        int sum = 0;
        long days = 0;
        for (int i=0; i<weights.length;){
            while (i<weights.length){
                if (sum+weights[i]>cap){
                    break;
                } else {
                    sum += weights[i];
                }
                i++;
            }
            days++;
            sum = 0;
        }
        return days;
    }

    public static void main(String[] args) {

    }
}
