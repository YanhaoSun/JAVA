package practices;

import java.util.HashMap;
import java.util.Scanner;

public class Pra2 {
    //左闭右闭
    public static int MathChallenge(int num) {
        // code goes here
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;

        int i = n-2;
        while (i>=0 && digits[i]>=digits[i+1]){
            i--;
        }

        if (i<0){
            return -1;
        }
        int j = n-1;
        while (digits[j]<=digits[i]){
            j--;
        }
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        reverse(digits, i+1, n-1);
        return Integer.parseInt(new String(digits));


        // int result = Integer.parseInt(new String(digits));
        // String token = "ih903y7lb";
        // String resultString = String.valueOf(result);
        // for (char ch : token.toCharArray()){
        //   resultString = resultString.replace(String.valueOf(ch), "--"+ch+"--");
        // }
        // return Integer.parseInt(resultString);

    }
    public static void reverse(char[] arr, int start, int end){
        while (start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

//    public static void main (String[] args) {
//        // keep this function call here
//        Scanner s = new Scanner(System.in);
//        int num = s.nextInt();
//        int result = MathChallenge(num);
//        String token = "ih903y7lb";
//        String resultString = String.valueOf(result);
//        for (char ch : token.toCharArray()){
//            resultString = resultString.replace(String.valueOf(ch), "--"+ch+"--");
//        }
//        System.out.print(resultString);
//
//        // System.out.print(MathChallenge(s.nextLine()));
//    }
public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    if (s.hasNextLine()){
        String input = s.nextLine();
        int num = 0;
        try{
            num = Integer.parseInt(input);
        } catch (NumberFormatException e){
            System.out.print("");
            return;
        }
        // int num = s.nextLine();

        // String input = s.nextLine();
        // int num = Integer.parseInt(input);

        int result = MathChallenge(num);
        String token = "ih903y7lb";
        String resultString = String.valueOf(result);
        for (char ch : token.toCharArray()){
            resultString = resultString.replace(String.valueOf(ch), "--"+ch+"--");
        }
        System.out.print(resultString);
    } else {
        System.out.print("No input");
    }
}
}

