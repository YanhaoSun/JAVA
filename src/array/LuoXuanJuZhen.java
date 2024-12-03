package array;

public class LuoXuanJuZhen {
    //螺旋矩阵
    public static int[][] generateMatrix(int n) {
        int [][] result = new int[n][n];
        int startX = 0, startY = 0; // start point of each circle
        int count=1; // the number that fills in the matrix
        int offset = 1;
        int loop = 1; // record current iteration
        int i, j; // i represents row, j represents column

        while(loop <= n/2){
            for (j = startY; j < n-offset; j++){
//                System.out.println("count = "+count);
//                System.out.println("i, j = "+i+j);
//                System.out.println();
                result[startX][j] = count++;
            }
            for (i=startX; i<n-offset; i++){
                result[i][j] = count++;
            }
            for (; j>startY; j--){
                result[i][j] = count++;
            }
            for (; i>startX; i--){
                System.out.println("i = "+i);
                result[i][startY] = count++;
            }
            loop ++;
            offset ++;
            startX ++;
            startY ++;
        }
        // this indicates n is odd number
        if (n%2==1){
            result[startX][startY] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] array = new int[n][n];
        array = LuoXuanJuZhen.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
