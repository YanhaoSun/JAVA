package Daily_Implementation;
public class repeatedSquaring
{
    Integer abc;
    String binaryExp;
    public repeatedSquaring(int base, Integer exp, int mod)
    {
        abc = exp;
        System.out.println(abc);
        binaryExp = Integer.toBinaryString(abc);
//      Integer binary = Integer.valueOf(binaryExp);
    }

    public void buildBinary(int[] storeBinary, int index)
    {
        String store = "";
        for(int i=0; i<index; i++)
        {
            store += binaryExp.charAt(i);
            //storeBinary[index-1] = Integer.parseInt(String.valueOf());
        }
        System.out.println("index = "+index);
        storeBinary[index-1] = Integer.parseInt(store, 2);
        if(index==binaryExp.length())
        {
            return;
        }
        index++;
        buildBinary(storeBinary, index);
    }

    public static void main(String[] args) {
        repeatedSquaring first = new repeatedSquaring(5, 20, 35);
        int[] storeBinary = new int[5];
        int index = 1;
        first.buildBinary(storeBinary, index);
        for (int i: storeBinary)
        {
            System.out.println("i = "+i);
        }
    }
}
