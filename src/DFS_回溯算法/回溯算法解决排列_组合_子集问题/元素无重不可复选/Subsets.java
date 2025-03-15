package DFS_回溯算法.回溯算法解决排列_组合_子集问题.元素无重不可复选;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 力扣78
 * medium
 */
public class Subsets {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0);
        return res;
    }
    public void backTrack(int[] nums, int start){
        res.add(new LinkedList<>(track));
        for (int i=start; i<nums.length; i++){
            track.addLast(nums[i]);
            backTrack(nums, i+1);
            track.removeLast();
        }
    }
}
