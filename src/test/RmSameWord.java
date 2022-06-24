package test;

import java.util.Scanner;

/**
 * @author szw
 * @date 2022/6/20 14:41
 */
public class RmSameWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i++) {
            for (int j = i + 1; j < sb.length(); j++) {
                if (sb.charAt(i) == sb.charAt(j) && !",".equals(sb.charAt(i))) {
                    sb.deleteCharAt(j);
                    j--;
                }
            }
        }
        System.out.println("new string: " + sb);
    }
}
