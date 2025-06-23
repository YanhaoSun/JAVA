package 线性表.数组.强化练习数组双指针经典习题;

import sun.awt.image.ImageWatched;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 力扣1329
 * medium
 */
public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        // 存储所有对角线的元素
        HashMap<Integer, LinkedList<Integer>> dia = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                dia.putIfAbsent(i-j, new LinkedList<>());
                dia.get(i-j).addLast(mat[i][j]);
            }
        }
        // 对每个对角线的元素进行排序
        for (LinkedList<Integer> diagonal: dia.values()){
            Collections.sort(diagonal, Collections.reverseOrder());
        }
        // 把对角线的元素再放回矩阵中
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                mat[i][j] = dia.get(i-j).removeLast();
            }
        }
        return mat;
    }
}
