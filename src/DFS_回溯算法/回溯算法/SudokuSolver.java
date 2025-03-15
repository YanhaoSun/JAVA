package DFS_回溯算法.回溯算法;

/**
 * 力扣37
 * hard
 */
public class SudokuSolver {
    boolean found = false;
    public void solveSudoku(char[][] board) {
        backTrack(board, 0);
    }
    public void backTrack(char[][] board, int index){
        // 这部分if else注释点也能运行
        if (found){
            return;
        }
        int m=9, n=9;
        int i=index/n, j=index%n;
        if (index==m*n){
            found = true;
            return;
        }
        if (board[i][j]!='.'){
            backTrack(board, index+1);
            return;
        }
        for (char ch = '1'; ch<='9'; ch++ ){
            if (!valid(board, i, j, ch)){
                continue;
            }
            board[i][j] = ch;
            backTrack(board, index+1);
            if (found){
                return;
            }
            board[i][j]='.';
        }
    }
    public boolean valid(char[][] board, int r, int c, char num){
        for (int i=0; i<9; i++){
            if (board[r][i]==num){
                return false;
            }
            if (board[i][c]==num){
                return false;
            }
            if (board[(r/3)*3+i/3][(c/3)*3+i%3]==num){
                return false;
            }
        }
        return true;
    }
}
