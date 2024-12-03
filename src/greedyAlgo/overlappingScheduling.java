package greedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class overlappingScheduling {
    public static int overlapSchedulingAlgo(List<List<Integer>> interval){
        if (interval.isEmpty()) return 0;
        interval.sort((a, b) -> Integer.compare(a.get(1), b.get(1)));
        int arrows = 1;
        int firstEnd = interval.get(0).get(1);
        for (List<Integer> val: interval){
            System.out.println(val);
            if (firstEnd<val.get(0)){
                firstEnd = val.get(1);
                arrows++;
            }
        }
        return arrows;
    }

    public static int overlapSchedulingAlgo1(List<List<Integer>> interval){
        if (interval.isEmpty()) return 0;
        interval.sort((a, b) -> Integer.compare(a.get(1), b.get(1)));
        int firstEnd = interval.get(0).get(1);
        int arrows = 1;
        for (List<Integer> val: interval){
            if (val.get(0)>firstEnd){
                firstEnd = val.get(1);
                arrows ++;
            }
        }
        return arrows;
    }
    public static void main(String[] args) {
//        [[10,16], [2,8], [1,6], [7,12]]
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(10, 16));
        input.add(Arrays.asList(2, 8));
        input.add(Arrays.asList(1, 6));
        input.add(Arrays.asList(7, 12));

//        [1,3],[3,5],[3,7],[6,9],[8,10],[10, 11], [10, 12], [14, 15]
        List<List<Integer>> input1 = new ArrayList<>();
        input1.add(Arrays.asList(14, 15));
        input1.add(Arrays.asList(8, 10));
        input1.add(Arrays.asList(6, 9));
        input1.add(Arrays.asList(10, 12));
        input1.add(Arrays.asList(3, 7));
        input1.add(Arrays.asList(3, 5));
        input1.add(Arrays.asList(10, 11));
        input1.add(Arrays.asList(1, 3));


        int result = overlapSchedulingAlgo1(input1);
        System.out.println("result = "+result);
    }
}
