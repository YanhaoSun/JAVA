package array.双指针技巧.左右指针.反转数组.矩阵的螺旋遍历;
import java.util.ArrayList;
import java.util.List;
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int leftBound = 0;
        int rightBound = n-1;
        int upperBound = 0;
        int lowerBound = n-1;
        int num = 1;
        while (num<=n*n){
            if (upperBound<=lowerBound) {
                for (int j = leftBound; j <= rightBound; j++) {
                    matrix[upperBound][j] = num++;
                }
                upperBound++;
            }
            if (leftBound<=rightBound){
                for (int i=upperBound; i<=lowerBound; i++){
                    matrix[i][rightBound] = num++;
                }
                rightBound--;
            }
            if (upperBound<=lowerBound){
                for (int j=rightBound; j>=leftBound; j--){
                    matrix[lowerBound][j] = num++;
                }
                lowerBound--;
            }
            if (leftBound<=rightBound){
                for (int i=lowerBound; i>=upperBound; i--){
                    matrix[i][leftBound] = num++;
                }
                leftBound++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
    }
}
