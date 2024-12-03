package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class checkExistPath {
    public static boolean checkEachPoint(List<List<String>> board, String word) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(0).size(); j++) {
                if (DFSExist(i, j, word, 0, board)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean DFSExist(int i, int j, String word, int step, List<List<String>> board){
        int rows = board.size();
        int columns = board.get(0).size();
        if (i<0 || i>=rows || j<0 || j>=columns || !Objects.equals(board.get(i).get(j), String.valueOf(word.charAt(step)))) {
            return false;
        }
        if (step==word.length()-1) {
            return true;
        }
        String temp = board.get(i).get(j);
        board.get(i).set(j, "/");
        boolean res = DFSExist(i-1, j, word, step+1, board) || DFSExist(i+1, j, word, step+1, board) || DFSExist(i, j-1, word, step+1, board) || DFSExist(i, j+1, word, step+1, board);
        board.get(i).set(j, temp);
        return res;
    }

    public static boolean checkEachPoint1(List<List<String>> board, String word) {
        for (int i=0; i<board.size(); i++){
            for (int j=0; j<board.get(0).size(); j++){
                if (DFSExist1(i, j, word, 0, board)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean DFSExist1(int i, int j, String word, int step, List<List<String>> board){
        int rows = board.size();
        int columns = board.get(0).size();
        if (i<0 || i>=rows || j<0 || j>=columns || Objects.equals(board.get(i).get(1), String.valueOf(word.charAt(step)))){
            return false;
        }
        if (step==word.length()-1){
            return true;
        }
        String temp = board.get(i).get(j);
        board.get(i).set(j, "/");
        boolean res = DFSExist1(i-1, j, word, step+1, board) || DFSExist1(i+1, j, word, step+1, board) || DFSExist1(i, j-1, word, step+1, board) || DFSExist1(i, j+1, word, step+1, board);
        board.get(i).set(j, temp);
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> board = new ArrayList<>();
        board.add(Arrays.asList("a","b","c","e"));
        board.add(Arrays.asList("s","f","c","s"));
        board.add(Arrays.asList("a","d","e","e"));
        String word = "bfceese";
        System.out.println(checkEachPoint1(board, word));
    }
}