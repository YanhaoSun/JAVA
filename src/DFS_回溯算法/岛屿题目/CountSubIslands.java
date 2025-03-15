package DFS_回溯算法.岛屿题目;

/**
 * 力扣1905
 * medium
 */
public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        int m = grid1.length;
        int n = grid1[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid1[i][j]==0 && grid2[i][j]==1){
                    floodFill(grid2, i, j);
                }
            }
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid2[i][j]==1){
                    res++;
                    floodFill(grid2, i, j);
                }
            }
        }
        return res;
    }
    public void floodFill(int[][] grid2, int i, int j){
        int m = grid2.length;
        int n = grid2[0].length;
        if (i<0 || j<0 || i>=m || j>=n){
            return;
        }
        if (grid2[i][j]==0){
            return;
        }
        grid2[i][j]=0;
        floodFill(grid2, i-1, j);
        floodFill(grid2, i+1, j);
        floodFill(grid2, i, j-1);
        floodFill(grid2, i, j+1);
    }
}
