package doublePointers.DollidingPointers;

import java.util.ArrayList;
import java.util.List;

public class maxArea {
    public static int[] maxAreaAlgo(List<Integer> height){
        int left=0;
        int right=height.size()-1;
        int max = 0;
        int[] result = new int[2];
        while (left<right){
            int area = Math.min(height.get(left), height.get(right))*(right-left);
            if (area>max){
                max = area;
                result[0] = left;
                result[1] = right;
            }
            if (height.get(left)<height.get(right)){
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> height = new ArrayList<>();
        height.add(2);
        height.add(4);
        height.add(2);
        height.add(5);
        height.add(9);
        height.add(43);
        height.add(34);
        height.add(65);
        height.add(8);
        height.add(2);
        height.add(1);
        int[] result = maxAreaAlgo(height);
        System.out.println("maxArea height = "+result[0]+", "+result[1]);
    }
}
