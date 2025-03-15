package DFS_回溯算法.回溯算法解决排列_组合_子集问题.元素可重不可复选;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * 力扣90
 * medium
 */
public class SubsetsII {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0);
        return res;
    }
    public void backTrack(int[] nums, int start){
        res.add(new LinkedList<>(track));
        for (int i=start; i<nums.length; i++){
            if (i>start && nums[i]==nums[i-1]){
                continue;
            }
            track.addLast(nums[i]);
            backTrack(nums, i+1);
            track.removeLast();
        }
    }
}
