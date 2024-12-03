package Daily_Implementation;


public class reverse_Words_In_String
{
    //this is the clever way to implement this
    public String Clever_spinWords(String sentence)
    {
        String[] store = sentence.split(" ");
        for(int i=0; i<store.length; i++)
        {
            if(store[i].length()>4)
            {
                store[i] = new StringBuilder(store[i]).reverse().toString();
            }
        }
        String result = String.join(" ", store);
        return result;
    }
    //this is the stupid way to implement this
    public String Stupid_spinWords(String sentence) {
        int countBetweenSpace = 0;
        int wordStart = 0;
        int wordEnd = 0;
        char[] storeString = new char[sentence.length()];
        String result;
        for(int i=0; i<sentence.length(); i++)
        {
            char curr = sentence.charAt(i);
            if((curr!= ' ') && (i+1!=sentence.length()))
            {
                countBetweenSpace++;
            }
            else
            {
                if((curr!= ' ') && (i+1==sentence.length()))
                {
                    countBetweenSpace++;
                }
                wordEnd=wordStart+(countBetweenSpace-1);
                if(countBetweenSpace<5)
                {
                    for(int m=wordStart; m<=wordEnd; m++)
                    {
                        storeString[m] = sentence.charAt(m);
                    }
                    if(i!=sentence.length()-1)
                    {
                        storeString[wordEnd+1] = ' ';
                    }
                }
                if(countBetweenSpace>=5)
                {
                    int a = wordStart;
                    for(int m=wordEnd; m>=wordStart; m--)
                    {
                        storeString[a] = sentence.charAt(m);
                        a++;
                    }
                    if(i!=sentence.length()-1)
                    {
                        storeString[wordEnd+1] = ' ';
                    }
                }
                countBetweenSpace=0;
                wordStart = i+1;
            }
            if((i==sentence.length()-1) && (sentence.charAt(i)==' '))
            {
                storeString[i] = ' ';
            }
        }
        result = String.valueOf(storeString);
        return result;
    }

    public static void main(String[] args) {
        reverse_Words_In_String first = new reverse_Words_In_String();
        System.out.println(first.Clever_spinWords( "Hey fellow warriors" ));
        //System.out.println(first.spinWords( "Hey fellow warriors " ));
    }
}
