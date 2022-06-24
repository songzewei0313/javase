package dsa.sort;

import java.util.Arrays;

/**
 * 选择排序算法
 *
 * @author szw
 */
public class SelectSort {

    public static void selectSort(int[] arr) {
        //校验下数组
        if (arr == null || arr.length < 2) {
            return;
        }
        //选择排序特点，要成功把数组大小-1个最小值依次放到数组中，才能排序成功，相当于要进行arr.length-1 次外循环
        for (int i = 0; i < arr.length - 1; i++) {
            //要找最小值，先假定第一个数（arr[0]即arr[i]）为最小值，即最小值的位置在第一位，即为i（0）
            //如果第一次循环结束，说明已经找到第一个最小值，下次找到最小值，应放到index为1的位置，即i=1，arr[1]为最小值
            int min = arr[i];
            int minIndex = i;
            //这个循环是要找最小值；**j = i+1 说明我当前的数值应该要和下一个数值比大小；并且要和后面所有数值进行比较，因此是循环
            for (int j = i + 1; j < arr.length; j++) {
                //说明假定的最小值不是真正的最小值，
                if (min > arr[j]) {
                    //那就把真正的最小值arr[j] 赋值给min
                    min = arr[j];
                    //把真正最小值的下标j 赋值给minIndex，那么新的minIndex应该为假定值的数组下标
                    minIndex = j;
                    //说白了，把假定最小值重置，因为我找到了比假定最小值还小的数，
                    // 注意没有交换位置，如果一直有比假定值小的数，一直重置
                }
            }
            //说明：i(应该是)本轮最小值所在的数组下标（但事实不是）；minIndex（被定义为）一直就是最小值的数组下表；如果minIndex != i
            // 说明在最小值所在的位置上不是真正的最小值，也就是说最小值的数组下标minIndex变了，变成真正的最小值所在的数组的索引
            // 说白了，就是交换最小值和假定值的位置
            if (minIndex != i) {
                //i(应该是)本轮最小值所在的数组下标（但事实不是），所以先把假定值放到最小值原来所在的位置上
                arr[minIndex] = arr[i];
                //然后把真正最小值min放到i位置上
                arr[i] = min;
            }
        }

    }

    public static void main(String[] args) {
        //测试一下
        int[] arr = {3, 9, -1, 10, 20};
        System.out.println("原数组：" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("选择排序后数组：" + Arrays.toString(arr));
    }
}
