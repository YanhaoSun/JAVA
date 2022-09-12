package practices;
import java.util.Arrays;
/*Write a function that takes in a string of one or more words,
  and returns the same string, but with all five or more letter words reversed
  (Just like the name of this Kata).
  Strings passed in will consist of only letters and spaces.
  Spaces will be included only when more than one word is present.*/

/*
    for example:
        spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
        spinWords( "This is a test") => returns "This is a test"
        spinWords( "This is another test" )=> returns "This is rehtona test"*/
public class pra1 {
    public String spinWords(String sentence) {
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
        pra1 first = new pra1();
        System.out.println(first.spinWords( "Hey fellow warriors" ));
        //System.out.println(first.spinWords( "Hey fellow warriors " ));
    }
}
