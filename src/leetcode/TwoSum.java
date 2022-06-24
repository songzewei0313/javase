package leetcode;

import dsa.hashtab.HashTab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author szw
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        //如果没找到，返回空数组{}
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = {-1, 1, 3, 13, 33, 69};
        int target = 16;
        //结果为[2,3]，3+13=16
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}
