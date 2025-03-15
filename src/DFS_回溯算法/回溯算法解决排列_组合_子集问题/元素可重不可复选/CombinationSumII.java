package DFS_回溯算法.回溯算法解决排列_组合_子集问题.元素可重不可复选;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * 力扣40
 * medium
 */
public class CombinationSumII {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length==0){
            return res;
        }
        Arrays.sort(candidates);
        backTrack(candidates, 0, target);
        return res;
    }
    public void backTrack(int[] candidates, int start, int target){
        if (trackSum==target){
            res.add(new LinkedList<>(track));
            return;
        }
        if (trackSum>target){
            return;
        }
        for (int i=start; i<candidates.length; i++){
            if (i>start && candidates[i-1]==candidates[i]){
                continue;
            }
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            backTrack(candidates, i+1, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
