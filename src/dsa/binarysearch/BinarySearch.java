package dsa.binarysearch;

/**
 * @author szw
 * @date 2022/4/2 14:34
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,8,9,13,36,108};
        System.out.println(binarySearch(arr,13));
    }

    /**
     * 二分查找-非递归实现
     * @param arr     有序数组 本方法为升序
     * @param target  目标值
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
