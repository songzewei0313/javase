package test;

/**
 * @author Songzw
 */
public class RegexTest {

    public static void main(String[] args) {
        String s = "，";
        regex1(s);
        s = ".";
        regex1(s);
        s = "；";
        regex1(s);
        s = "。";
        regex1(s);
        s = "大叔大婶，";
        regex1(s);
        s = "，‘’";
        regex1(s);
    }

    private static void regex(String str) {
        boolean b = str.matches("[1-9]{4}$");
        System.out.println(b);
    }

    private static void regex1(String str) {
        boolean b = str.matches("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]");
        System.out.println(b);
    }
}
