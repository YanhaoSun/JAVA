package array;

import java.util.Scanner;

public class kaiFaShangMaiTuDi {
    public static void main(String[] args) {
        Scanner  input = new Scanner(System.in);
        Integer value = input.nextInt();
        Integer n =  Character.getNumericValue(value.toString().charAt(0));
        Integer m = Character.getNumericValue(value.toString().charAt(1));

        int[][] array = new int[n][m];
        int row=0;
        int[] rowSumArray = new int[n];
        int[] columnSumArray = new int[m];
        int rowSum = 0;
        while(row<n && input.hasNext()){
            Integer intValue = input.nextInt();
            int sum = 0;
            for (int i=0; i<m; i++){
                Integer num = Character.getNumericValue(intValue.toString().charAt(i));
                array[row][i] = num;
                sum += num;
            }
            rowSum += sum;
            rowSumArray[row] = rowSum;
            row++;
        }

        input.close();
        int columnSum = 0;
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += array[i][j];
            }
            columnSum += sum;
            columnSumArray[j] = columnSum;
        }

        int columnDiff = Integer.MAX_VALUE;
        for(int i=0; i<columnSumArray.length; i++){
            int frontSum = columnSumArray[i];
            int rearSum = columnSumArray[columnSumArray.length-1] - columnSumArray[i];
            if (columnDiff > Math.abs((frontSum-rearSum))){
                columnDiff = Math.abs((frontSum-rearSum));
            }
        }

        int rowDiff = Integer.MAX_VALUE;
        for(int i=0; i<rowSumArray.length; i++){
            int frontSum = rowSumArray[i];
            int rearSum = rowSumArray[rowSumArray.length-1] - rowSumArray[i];
            if (rowDiff > Math.abs((frontSum-rearSum))){
                rowDiff = Math.abs((frontSum-rearSum));
            }
        }

        if (columnDiff < rowDiff){
            System.out.println("columnDiff = "+columnDiff);
        } else {
            System.out.println("rowDiff = "+rowDiff);
        }

    }
}
