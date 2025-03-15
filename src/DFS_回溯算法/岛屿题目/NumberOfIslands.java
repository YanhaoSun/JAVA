package DFS_回溯算法.岛屿题目;

/**
 * 力扣200
 * medium
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j]!='0'){
                    res++;
                    floodFill(grid, i, j);
                }
            }
        }
        return res;
    }
    public void floodFill(char[][] grid, int i, int j){
        if (i<0 || j<0 || i>=grid.length || j>=grid[i].length){
            return;
        }
        if (grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        floodFill(grid, i-1, j);
        floodFill(grid, i+1, j);
        floodFill(grid, i, j-1);
        floodFill(grid, i, j+1);
    }
}
