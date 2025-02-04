package array.双指针技巧.左右指针.反转数组.顺逆时针旋转矩阵;

/**
 * 力扣48
 * medium
 */
public class RotateImage {
    public static void clockWiseRotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] row: matrix){
            reverse(row);
        }
    }

    /**
     * 逆时针这里的坐标处理一定要注意
     * [0, 3] <-> [0, 3]    [1, 2] <-> [1, 2]
     * [0, 2] <-> [1, 3]    [1, 1] <-> [2, 2]
     * [0, 1] <-> [2, 3]    [1, 0] <-> [3, 2]
     * [0, 0] <-> [3, 3]
     * @param matrix
     */
    public static void antiClockWiseRotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n; i++){
            int count = 0;
            for (int j=n-i-1; j>=0; j--){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i+count][j+count];
                matrix[i+count][j+count] = temp;
                count++;
            }
        }
        for (int[] row: matrix){
            reverse(row);
        }
    }
    public static void reverse(int[] row){
        int left = 0;
        int right = row.length-1;
        while (left < right){
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        antiClockWiseRotate(matrix);
        for (int[] row: matrix){
            for (int a: row){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}