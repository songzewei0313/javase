package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 22264
 */
public class ArrTest {

    public static void main(String[] args) {
        int[] arr = new int[3];
        String[] strArr = new String[3];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] a;
        a = Arrays.copyOf(arr, 2 * arr.length);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void test(){
        Integer[] arr = new Integer[3];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        Integer[] a;
        a = Arrays.copyOf(arr, 2 * arr.length);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void binarySearchTest(){
        Integer[] arr = new Integer[33];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int i = Arrays.binarySearch(arr, 15);
        System.out.println(i);
    }
}
