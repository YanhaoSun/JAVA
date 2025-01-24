package practices;

import java.util.ArrayList;
import java.util.Objects;

public class test {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length());

    }

    public static int methodA() {
        try {
            return 10;
        } finally {
            System.out.println("Finally block executed");
        }
    }
}