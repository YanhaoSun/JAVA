package Daily_Implementation;

public class Test_Prime_Number {
    public static boolean clever_isPrime(int num)
    {
        if(num<2)
        {
            return false;
        }
        else
        {
            for(int i=2; i<=Math.sqrt(num); i++)
            {
                if(num%i==0)
                {
                    return false;
                }
            }
            return true;
        }
    }
    public static boolean stupid_isPrime(int num)
    {
        if(num <= 1)
        {
            return false;
        }
        for(int i=2; i<=num/2; i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(stupid_isPrime(169));
        System.out.println(clever_isPrime(5347));
    }
}
