package test;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author song
 */
public class EqualsAndHashCodeTest {
    @Test
    public void test(){
        String s1 = new String("s");
        String s2 = new String("s");
        Set set = new HashSet();
        set.add(s1);
        System.out.println(set.contains(s2));
        set.remove(s1);
        System.out.println();
    }

    @Test
    public void test1(){
        String s = "song";
        int i10 = s.hashCode();
        String s2 = Integer.toBinaryString(i10);
//        int i2 = Integer.valueOf(s2);
        int i2 = 0;
        int i = i2 & 1111;
        System.out.println(i);
    }
}
