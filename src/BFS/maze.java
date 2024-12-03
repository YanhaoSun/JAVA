package BFS;

import list.ListNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class maze {
    public static int BFS(int[][] maze, int[] target){
        Queue<int[]> Q = new ArrayDeque<>();
        int rows = maze.length;
        int columns = maze[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int[] start = new int[]{0, 0, 0};
        int[] end = target;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        visited[start[0]][start[1]] = true;
        Q.add(start);
        while (!Q.isEmpty()){
            int[] curr = Q.poll();
            int xCor = curr[0];
            int yCor = curr[1];
            int steps = curr[2];
            for (int[] dir: dirs){
                int[] cur = new int[]{xCor+dir[0], yCor+dir[1], steps+1};
                if (cur[0]==end[0] && cur[1]==end[1]){
                    return steps+1;
                }
                if (isValid(maze, cur) && !visited[cur[0]][cur[1]]){
                    Q.add(cur);
                    visited[cur[0]][cur[1]] = true;
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int[][] maze, int[] node){
        int rows = maze.length;
        int columns = maze[0].length;
        if ((node[0]>=0 && node[0]<rows) && (node[1]>=0 && node[1]<columns) && maze[node[0]][node[1]]==0){
            return true;
        }
        return false;
    }


    public static int BFS_Algo1(int[][] maze, int[] target){
        int rows = maze.length;
        int columns = maze[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int[] start = new int[]{0, 0, 0};
        Queue<int[]> Q = new ArrayDeque<>();
        Q.add(start);
        visited[start[0]][start[1]] = true;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!Q.isEmpty()){
            int[] curr = Q.poll();
            int corX = curr[0];
            int corY = curr[1];
            int steps = curr[2];
            for (int[] dir: dirs){
                int[] temp = new int[]{corX+dir[0], corY+dir[1], steps+1};
                if (temp[0]==target[0] && temp[1]==target[1]){
                    return steps+1;
                } if (isValid_Algo1(maze, temp) && !visited[temp[0]][temp[1]]){
                    Q.add(temp);
                    visited[temp[0]][temp[1]] = true;
                }
            }
        }
        return -1;
    }

    private static boolean isValid_Algo1(int[][] maze, int[] node){
        int rows = maze.length;
        int columns = maze[0].length;
        if ((node[0]<rows && node[0]>=0) && (node[1]<columns && node[1]>=0) && maze[node[0]][node[1]]==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{{0,1,0,0,0}, {0,1,0,1,0}, {0,0,0,0,0}, {0,1,1,1,0}, {0,0,0,1,0}};
        int[] target = new int[]{4, 4};
        int steps = BFS_Algo1(maze, target);
        System.out.println(steps);
    }
}
