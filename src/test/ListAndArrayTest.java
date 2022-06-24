package test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListAndArrayTest {
    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        test2(list.toArray(new String[0]));
    }

    public void test2(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
