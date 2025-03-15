package DFS_回溯算法.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * 力扣52
 * hard
 */
public class NQueensII {
    int res = 0;
    public int totalNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i=0; i<n; i++){
            char[] row = new char[n];
            for (int j=0; j<n; j++){
                row[j] = '.';
            }
            board.add(new String(row));
        }
        backTrack(board, 0);
        return res;
    }
    public void backTrack(List<String> board, int row) {
        if (board.size() == row) {
            res++;
            return;
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)){
                continue;
            }
            char[] r = board.get(row).toCharArray();
            r[col] = 'Q';
            board.set(row, new String(r));
            backTrack(board, row+1);
            r[col] = '.';
            board.set(row, new String(r));
        }
    }
    public boolean isValid(List<String> board, int row, int col){
        int n = board.size();
        for (int i=0; i<=row; i++){
            if (board.get(i).charAt(col)=='Q'){
                return false;
            }
        }
        for (int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
            if (board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if (board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        return true;
    }
}
