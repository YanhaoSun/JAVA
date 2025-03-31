package BFS算法.BFS算法解题套路框架;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 力扣773
 * hard
 */
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start = start + board[i][j];
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        HashSet<String> visited = new HashSet<>();
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (target.equals(cur)) {
                    return step;
                }
                for (String newBoard :getNeighbors(cur)){
                    if (!visited.contains(newBoard)){
                        queue.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public List<String> getNeighbors(String board){
        int[][] map = new int[][]{
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}
        };
        int index = board.indexOf('0');
        List<String> newNeighbors = new LinkedList<>();
        for (int pos: map[index]){
            String newBoard = switchBoard(board.toCharArray(), index, pos);
            newNeighbors.add(newBoard);
        }
        return newNeighbors;
    }
    public String switchBoard(char[] board, int old, int newInd){
        char temp = board[old];
        board[old] = board[newInd];
        board[newInd] = temp;
        return new String(board);
    }
}
