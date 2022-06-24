package dsa.stack;

import org.junit.jupiter.api.Test;

/**
 * 回文
 *
 * @author songzw
 */
public class Palindrome {
    public static void main(String[] args) {
        String str = "abcdedcba";
        System.out.println(isHw(str));
    }

    /**
     * 用自己写的栈实现->判断是否是回文
     *
     * @param str
     * @return
     */
    public static boolean isHw(String str) {
        ArrayStack arrayStack = new ArrayStack(10);
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (arrayStack.isFull()) {
                throw new RuntimeException("栈满");
            }
            arrayStack.push(c);
        }

        int length = arrayStack.length();

        for (int i = 0; i < length; i++) {
            char c = (char) arrayStack.pop();
            newStr = newStr + c;
        }

        if (str.equals(newStr)) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        System.out.println(isHw1("abcdefedcba"));
    }

    /**
     * 自己写个算法判断是否是回文
     *
     * @param str
     * @return
     */
    public boolean isHw1(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) == str.charAt(length - i - 1)) {
                continue;
            } else return false;
        }
        return true;
    }
}
