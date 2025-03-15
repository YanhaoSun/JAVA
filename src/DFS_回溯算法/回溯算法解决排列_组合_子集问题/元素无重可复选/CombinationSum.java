package DFS_回溯算法.回溯算法解决排列_组合_子集问题.元素无重可复选;
import java.util.LinkedList;
import java.util.List;
/**
 * 力扣39
 * medium
 */
public class CombinationSum {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0);
        return res;
    }
    public void backTrack(int[] candidates, int target, int start){
        if (trackSum==target){
            res.add(new LinkedList<>(track));
            return;
        }
        if (trackSum>target){
            return;
        }
        for (int i=start; i<candidates.length; i++){
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            backTrack(candidates, target, i);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
