package practices; /**
 ** Java Program to Implement Repeated Squaring Algorithm
 **/

import java.util.Scanner;

/** Class RepeatedSquaring **/
public class RepeatedSquaring
{
    /** Function for repeated squaring **/
    public double expBySquaring(double x, int n)
    {
        if (n < 0)
            return expBySquaring(1 / x, -n);
        else if (n == 0)
            return 1;
        else if (n == 1)
            return x;
        else if (n % 2 == 0)
            return expBySquaring(x * x, n / 2);
        else
            return x * expBySquaring(x * x, (n - 1)/2);
    }
    /** Main function **/
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Repeated Squaring Algorithm Test\n");
        /** Make an object of RepeatedSquaring class **/
        RepeatedSquaring rs = new RepeatedSquaring();

        /** Accept n , k **/
        System.out.println("\nEnter n and k of (N ^ K)");
        double n = scan.nextDouble();
        int k = scan.nextInt();
        double result = rs.expBySquaring(n, k) % 35;

        System.out.println("\nResult : "+ result);
    }
}