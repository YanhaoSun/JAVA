package DFS_回溯算法.回溯算法;
//import org.graalvm.compiler.phases.graph.ScopedPostOrderNodeIterator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 力扣51
 * hard
 */
public class NQueens {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i=0; i<n; i++){
            char[] row = new char[n];
            for (int j=0; j<n; j++){
                row[j] = '.';
            }
            board.add(new String(row));
//            board.set(i, new String(row));
        }
        backTrack(board, 0);
        return res;
    }
    public void backTrack(List<String> board, int row){
        if (row==board.size()){
            res.add(new ArrayList<>(row));
            return;
        }
        int n = board.get(row).length();
        for (int col=0; col<n; col++){
            if (!isValid(board, row, col)){
                continue;
            }
            char[] r = board.get(row).toCharArray();
            r[col] = 'Q';
            board.set(row, new String(r));
            backTrack(board, row + 1);
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
        for (int i=row-1, j = col-1; i>=0 && j>=0; i--, j--){
            if (board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        return true;
    }
}
