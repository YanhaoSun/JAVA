package Amazon.OA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Prac {
    public static int minimumSets(List<Integer> a, List<Integer> b, int k) {
        // Write your code here
        int n = a.size();
        List<int[]> intervals = new ArrayList<>();
        for (int i=0; i<n; i++){
            intervals.add(new int[]{a.get(i), b.get(i)});
        }
        intervals.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> merged  = new ArrayList<>();
        List<Integer> gaps  = new ArrayList<>();

        int[] pre = intervals.get(0);
        for (int i=1; i<n; i++){
            int[] curr = intervals.get(i);
            if (curr[0] <= pre[1]){
                pre[1] = Math.max(pre[1], curr[1]);
            } else {
                merged.add(pre);
                gaps.add(curr[0]-pre[1]);
                pre = curr;
            }
        }
        merged.add(pre);

        boolean reduced = false;
        for (int gap: gaps){
            if (gap<=k){
                reduced = true;
                break;
            }
        }
        return merged.size() - (reduced? 1: 0);
    }
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(5);
        a.add(10);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(4);
        b.add(8);
        b.add(11);

        int res = minimumSets(a, b, 2);
        System.out.println(res);
    }
}
