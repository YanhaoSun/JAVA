package DFS_回溯算法.岛屿题目;

import java.util.HashSet;

public class 不同的岛屿数量 {
    public int numDistinctIslands(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> hashSet = new HashSet<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==1){
                    StringBuilder sb = new StringBuilder();
                    floodFill(grid, i, j, sb, 666);
                    hashSet.add(sb.toString());
                }
            }
        }
        return hashSet.size();
    }
    public void floodFill(int[][] grid, int i, int j, StringBuilder sb, int dir){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || j<0 || i>=m || j>=n){
            return;
        }
        if (grid[i][j]==0) {
            return;
        }
        sb.append(dir).append(",");
        grid[i][j]=0;
        floodFill(grid, i-1, j, sb, 1);
        floodFill(grid, i+1, j, sb, 2);
        floodFill(grid, i, j-1, sb, 3);
        floodFill(grid, i, j+1, sb, 4);
        sb.append(-dir).append(",");
    }

    public int numDistinctIslands_1(int[][] grid){
        HashSet<String> hashSet = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 666);
                    hashSet.add(sb.toString());
                }
            }
        }
        return hashSet.size();
    }
    public void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir){
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return;
        }
        if (grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        sb.append(dir).append(",");
        dfs(grid, i-1, j, sb, 1);
        dfs(grid, i+1, j, sb, 2);
        dfs(grid, i, j-1, sb, 3);
        dfs(grid, i, j+1, sb, 4);
        sb.append(-dir).append(",");
    }
}
