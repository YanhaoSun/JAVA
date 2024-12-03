package array;

import java.util.LinkedList;

public class Sieve_of_Eratosthenes {
    public static LinkedList<Integer> findAllPrimes(){
        LinkedList<Integer> primeList = new LinkedList<>();
        for(int i=0; i<1000; i++){
            primeList.add(i);
        }
        for (int i=0; i<primeList.size(); i++){
            Integer temp = primeList.get(i);
            if (temp>1){
                for (int j = temp*temp; j<1000; j += temp){
                    primeList.remove(Integer.valueOf(j));
                }
            }
        }
        return primeList;
    }
    public static void main(String[] args) {
        LinkedList<Integer> result = findAllPrimes();
        for (Integer prime: result) {
            System.out.print(" "+prime);
        }
    }
}
