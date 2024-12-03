package Daily_Implementation;

//Create a function with two arguments that will return an array of the first n multiples of x.
//
//Assume both the given number and the number of times to count will be positive numbers greater than 0.
//
//Return the results as an array or list ( depending on language ).

import java.util.ArrayList;

//Examples:
//        countBy(1,10)  // should return  {1,2,3,4,5,6,7,8,9,10}
//        countBy(2,5)  // should return {2,4,6,8,10}
public class n_multiples_of_x {
    public static int[] countBy(int x, int n){
        // Your code here
        int[] array = new int[n];
        for(int i=0; i<n; i++)
        {
            array[i] = x*(i+1);
        }
        return array;
    }

    public static void main(String[] args) {
        countBy(1,10);
        System.out.println(countBy(1,10)[1]);
    }
}