package DFS_回溯算法.岛屿题目;

/**
 * 力扣695
 * medium
 */
public class MaxAreaOfIsland {
    int count = 0;
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==1){
                    count = 0;
                    floodFill(grid, i, j);
                    if (count>area){
                        area = count;
                    }
                }
            }
        }
        return area;
    }
    public void floodFill(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || i>=m || j<0 || j>=n){
            return;
        }
        if (grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        count++;
        floodFill(grid, i+1, j);
        floodFill(grid, i-1, j);
        floodFill(grid, i, j-1);
        floodFill(grid, i, j+1);
    }
}
