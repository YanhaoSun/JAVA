package array.双指针技巧.左右指针.反转数组.矩阵的螺旋遍历;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int leftBound = 0;
        int rightBound = n-1;
        int upperBound = 0;
        int lowerBound = m-1;
        List<Integer> res = new ArrayList<>();
        while (res.size()<m*n){
            if (upperBound<=lowerBound){
                for (int j=leftBound; j<=rightBound; j++){
                    res.add(matrix[upperBound][j]);
                }
                upperBound++;
            }
            if (leftBound<=rightBound){
                for (int i=upperBound; i<=lowerBound; i++){
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            if (upperBound<=lowerBound){
                for (int j=rightBound; j>=leftBound; j--){
                    res.add(matrix[lowerBound][j]);
                }
                lowerBound--;
            }
            if (leftBound<=rightBound){
                for (int i=lowerBound; i>=upperBound; i--){
                    res.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
