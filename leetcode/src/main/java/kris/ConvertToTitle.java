package kris;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by zhouxuan on 16/7/15.
 */
public class ConvertToTitle {
    public static String convertToTitle(int n) {
        int base = 'a';
        String title = "";
        while (n != 0) {
            char letter = (char) (n % 26 + base);
            title = letter + title;
            n = n / 26;
        }
        return title;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + convertToTitle(i));
        }
    }
}
