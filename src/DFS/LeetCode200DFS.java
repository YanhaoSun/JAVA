package DFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode200DFS {
    static int islands = 0;
    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]=='1' && !visited[i][j]){
                    DFS(grid, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    public static boolean DFS(char[][] grid, int i, int j, boolean[][] visited){
        int rows = grid.length;
        int columns = grid[0].length;
        if (i<0 || i>=rows || j<0 || j>=columns || grid[i][j]!='1' || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        return DFS(grid, i-1, j, visited) || DFS(grid, i+1, j, visited) || DFS(grid, i, j-1, visited) || DFS(grid, i, j+1, visited);
    }
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','0','0','0'},
                                     {'1','1','0','0','0'},
                                     {'0','0','1','0','0'},
                                     {'0','0','0','1','1'}};
        int result = numIslands(grid);
        System.out.println(result);
    }
}
