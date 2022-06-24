package test;

/**
 * @author Szw
 */
public class IntegerTest {
    public static int getInteger(String s) {
        return Integer.getInteger(s);
    }

    public static int valueOf(String s) {
        return Integer.valueOf(s);
    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String s = "150313";
//        System.out.println(getInteger(s));
        System.out.println(valueOf(s));
        System.out.println(parseInt(s));
    }
}
