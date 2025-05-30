package 树.二叉搜索树.二叉搜索树心法_构造篇;

/**
 * 力扣96
 * medium
 */
public class UniqueBinarySearchTrees {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return count(1, n);
    }
    public int count(int lo, int hi){
        if (lo>hi) return 1;
        if (memo[lo][hi]!=0){
            return memo[lo][hi];
        }
        int res = 0;
        for (int i=lo; i<=hi; i++){
            int left = count(lo, i-1);
            int right = count(i+1, hi);
            res += left*right;
        }
        memo[lo][hi] = res;
        return res;
    }
}
