package Daily_Implementation;

public class conver_BooleanToString {
    public static String convert(boolean b){
        //return b ? "true" : "false";
        return Boolean.toString(b);
    }

    public static void main(String[] args) {
        System.out.println(convert(true));
    }
}