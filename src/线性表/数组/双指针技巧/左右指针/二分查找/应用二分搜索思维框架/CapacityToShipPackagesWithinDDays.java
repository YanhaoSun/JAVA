package 线性表.顺序存储结构.Array.双指针技巧.左右指针.二分查找.应用二分搜索思维框架;

/**
 * 力扣1011
 * medium
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight: weights){
            left = Math.max(left, weight);
            right += weight;
        }
        while (left<=right){
            int mid = left+(right-left)/2;
            if (daysRequired(weights, mid)>days){
                left = mid+1;
            } else if (daysRequired(weights, mid)<=days){
                right = mid-1;
            }
        }
        return left;
    }
    public static int daysRequired(int[] weights, int cap){
        int days = 0;
        for (int i=0; i<weights.length;){
            int x = cap;
            while (i<weights.length){
                if (x<weights[i]) break;
                else x -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
        for (int i=0; i<10;){
            int x = 4;
            while (i<5){
                if (x<=2) break;
                else x--;
                System.out.println("while i = "+i);
                i++;
            }
            System.out.println("for i = "+i);
        }
    }
}
