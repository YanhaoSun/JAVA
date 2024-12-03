package doublePointers.DollidingPointers;

import java.util.ArrayList;
import java.util.List;

public class threeSumClosest {
    public static int threeSumClosestAlgo(List<Integer> list, int target){
        list.sort((a, b) -> Integer.compare(a, b));
        int left = 0;
        int right = 0;
        int l = list.size();
        int num = Integer.MAX_VALUE;
        if (list.size()<3){
            return -1;
        }
        for (int i=0; i<list.size(); i++){
            left = i+1;
            right = l-1;
            while (left < right){
                int temp = list.get(i)+list.get(left)+list.get(right);
                if (Math.abs(temp-target)<Math.abs(num-target)){
                    num = temp;
                }
                if (temp>target){
                    right--;
                } else if (temp<target){
                    left++;
                } else {
                    return num;
                }
            }
        }
        return num;
    }
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(-2);
        input.add(-2);
        input.add(-1);
        input.add(-5);
        input.add(-8);
        input.add(1);
        input.add(3);
        input.add(2);
        input.add(7);
        input.add(10);
        System.out.println(threeSumClosestAlgo(input, 0));
    }
}
