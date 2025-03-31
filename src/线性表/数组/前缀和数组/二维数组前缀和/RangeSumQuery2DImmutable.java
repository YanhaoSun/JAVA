package 线性表.顺序存储结构.Array.前缀和数组.二维数组前缀和;

public class RangeSumQuery2DImmutable {
    private int[][] preSum;
    public RangeSumQuery2DImmutable(int[][] matrix){
        int m = matrix.length+1;
        int n = matrix[0].length+1;
        if (m == 1 && n == 1){
            return;
        }
        preSum = new int[m][n];
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                preSum[i][j] = preSum[i][j-1]+preSum[i-1][j]+matrix[i-1][j-1]-preSum[i-1][j-1];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1]-preSum[row2+1][col1]-preSum[row1][col2+1]+preSum[row1][col1];
    }
}
