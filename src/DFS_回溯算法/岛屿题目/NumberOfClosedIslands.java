package DFS_回溯算法.岛屿题目;

/**
 * 力扣1254
 * medium
 */
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int j=0; j<n; j++){
            floodFill(grid, 0, j);
            floodFill(grid, m-1, j);
        }
        for (int i=0; i<m; i++){
            floodFill(grid, i, 0);
            floodFill(grid, i, n-1);
        }
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    floodFill(grid, i, j);
                }
            }
        }
        return res;
    }
    public void floodFill(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || j<0 || i>=m || j>=n){
            return;
        }
        if (grid[i][j]==1){
            return;
        }
        grid[i][j]=1;
        floodFill(grid, i-1, j);
        floodFill(grid, i+1, j);
        floodFill(grid, i, j-1);
        floodFill(grid, i, j+1);
    }
}
