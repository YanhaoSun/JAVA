package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class leetCode200BFS {
    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]=='1' && !visited[i][j]){
                    BFS(grid, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    public static void BFS(char[][] grid, int i, int j, boolean[][] visited){
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dircs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> Q = new ArrayDeque<>();
        int[] start = new int[]{i, j};
        Q.add(start);
        visited[i][j] = true;
        while (!Q.isEmpty()){
            int[] curr = Q.poll();
            int corX = curr[0];
            int corY = curr[1];
            for (int[] dirc: dircs){
                int[] temp = new int[]{corX+dirc[0], corY+dirc[1]};
                if ((temp[0]>=0 && temp[0]<rows) && (temp[1]>=0 && temp[1]<columns) && grid[temp[0]][temp[1]]=='1' && !visited[temp[0]][temp[1]]){
                    visited[temp[0]][temp[1]] = true;
                    Q.add(temp);
                }
            }

        }
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
