package com.arr;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1.返回目标和的下标(两数之和)
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author liushuang 2019/3/26
 */
public class Leetcode1 {

    //方法1:双层循环 O(n²)

    //方法2  x+y=9   y=9-x
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // O(n)
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, i);
        }

        //O(n)  map是O(1)
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int y = target - num;
            //i != map.get(y) 不能重复使用
            if (map.containsKey(y) && i != map.get(y)) {
                return new int[]{i, map.get(y)};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] ints = {3, 3};
        int[] ints1 = twoSum2(ints, 6);
        System.out.println(Arrays.toString(ints1));
    }

    //一遍hash表
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            if (map.containsKey(y)) {
                return new int[]{map.get(y), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
