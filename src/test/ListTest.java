package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author song
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.remove("c");
        HashSet<String> strings = new HashSet<>(list);
        System.out.println(strings);
    }
}
