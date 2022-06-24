package dsa.sort;

import java.util.Arrays;

/**
 * @author songzw
 */
public class BubbleSort {
    /**
     * 冒泡排序算法
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        //临时变量，用来交换数值
        int temp;
        //标记变量，用来优化冒泡排序，具体是优化，如果在一趟循环中没有出现交换数据的情况，那么就跳出内部的循环
        boolean flag = false;
        //需要排序的趟数，每趟会选出最大的数据放到最后的位置，总共需要排数组的大小-1次
        for (int i = 0; i < arr.length - 1; i++) {
            //每一趟排序，需要比较相邻数据的次数会逐渐减少，并且可以优化（即标记变量的作用）
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 0, 13, -3};
        System.out.println("冒泡排序前数组：");
        System.out.println(Arrays.toString(arr));
        //模拟大数量用时
        /*int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }*/

        long l1 = System.currentTimeMillis();
        bubbleSort(arr);
        long l2 = System.currentTimeMillis();
        System.out.println("冒泡排序后数组：");
        System.out.println(Arrays.toString(arr));
        long l = l2 - l1;
        System.out.println("用时" + l + "ms");
    }
}
