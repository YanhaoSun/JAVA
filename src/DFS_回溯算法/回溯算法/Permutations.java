package DFS_回溯算法.回溯算法;
import java.util.LinkedList;
import java.util.List;
/**
 * 力扣46
 * medium
 */
public class Permutations {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used, track);
        return res;
    }
    public void backTrack(int[] nums, boolean[] used, LinkedList<Integer> track){
        if (track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (used[i]){
                continue;
            }
            track.addLast(nums[i]);
            used[i] = true;
            backTrack(nums, used, track);
            track.removeLast();
            used[i] = false;
        }
    }
}
