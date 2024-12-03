package doublePointers.DollidingPointers;

import java.util.ArrayList;
import java.util.List;

public class twoSum {
    public static int[] twoSumAlgo(List<Integer> list, int target){
        int slowIndex = 0;
        int fastIndex = list.size()-1;
        list.sort((a, b) -> Integer.compare(a, b));
        for (int val: list){
            System.out.print(val);
        }
        System.out.println();
        while (slowIndex < fastIndex){
            if ((list.get(slowIndex)+list.get(fastIndex))>target){
                fastIndex--;
            } else if ((list.get(slowIndex)+list.get(fastIndex))<target) {
                slowIndex++;
            } else {
                break;
            }
        }
        if (slowIndex < fastIndex){
            return new int[]{slowIndex, fastIndex};
        }
        return new int[]{0};
    }

    public static int[] twoSumAlgo1(List<Integer> list, int target){
        list.sort((a, b) -> Integer.compare(a, b));
        int left = 0;
        int right = list.size()-1;
        while (left<right){
            int sum = list.get(left)+list.get(right);
            if (sum>target) right--;
            else if (sum<target) left++;
            else break;
        }
        if (left < right) return new int[]{list.get(left),list.get(right)};
        return new int[2];
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(5); input.add(4); input.add(6); input.add(2); input.add(5); input.add(7); input.add(2); input.add(6); input.add(2);
        input.add(0);
//        <T> T = twoSumAlgo(input, 9);
        int[] result = twoSumAlgo1(input, 9);
        for (int val: result){
            System.out.print(val+", ");
        }
    }
}
