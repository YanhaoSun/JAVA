package DFS_回溯算法.回溯算法解决排列_组合_子集问题.元素可重不可复选;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 力扣47
 * medium
 */
public class PermutationsII {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used);
        return res;
    }
    public void backTrack(int[] nums, boolean[] used){
        if (nums.length==track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (used[i]){
                continue;
            }
            if (i>0 && nums[i-1]==nums[i] && !used[i-1]){
                continue;
            }
            used[i] = true;
            track.addLast(nums[i]);
            backTrack(nums, used);
            track.removeLast();
            used[i]=false;
        }
    }
}
