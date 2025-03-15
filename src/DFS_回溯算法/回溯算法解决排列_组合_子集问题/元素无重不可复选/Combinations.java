package DFS_回溯算法.回溯算法解决排列_组合_子集问题.元素无重不可复选;
import java.util.LinkedList;
import java.util.List;
/**
 * 力扣77
 * medium
 */
public class Combinations {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1,k);
        return res;
    }
    public void backtrack(int n, int start, int k){
        if (track.size()==k){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=start; i<=n; i++){
            track.addLast(i);
            backtrack(n, i+1, k);
            track.removeLast();
        }
    }
}
