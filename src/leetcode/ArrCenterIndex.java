package leetcode;

/**
 * @author szw
 * @date 2022/4/2 11:29
 */
public class ArrCenterIndex {
    public static void main(String[] args) {
//        int[] arr = {1, 7, 3, 6, 5, 6};
        int[] arr = {53,58,41,25,36,69,47};
//        int[] arr = {1, 2, 3};
//        System.out.println(pivotIndex(arr));
        System.out.println(pivotIndex1(arr));
    }

    public static int pivotIndex1(int[] nums) {
        int len = nums.length;
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        int max = sums[len];
        for (int i = 1; i <= len; i++) {
            if (sums[i - 1] == max - sums[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    public static int pivotIndex(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 2) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        if (arr.length == 3) {
            if (arr[0] == arr[2]) {
                return 1;
            } else {
                return -1;
            }
        }
        int index = arr.length / 2;
        return findIndex(arr, index);
    }

    public static int findIndex(int[] arr, int index) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < index; i++) {
            leftSum += arr[i];
        }
        for (int i = index + 1; i < arr.length; i++) {
            rightSum += arr[i];
        }
        if (leftSum > rightSum) {
            if (index <= 1) {
                return -1;
            } else {
                return findIndex(arr, index - 1);
            }
        } else if (rightSum > leftSum) {
            if (index >= arr.length - 1) {
                return -1;
            } else {
                return findIndex(arr, index + 1);
            }
        } else {
            return index;
        }
    }
}
