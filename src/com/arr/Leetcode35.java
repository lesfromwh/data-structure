package com.arr;

/**
 * @author liushuang
 * @Date 2019/10/28 3:59 下午
 */
public class Leetcode35 {

    public static void main(String[] args) {
        int i = searchInsert2(new int[]{1,3,5,6}, 2);
        System.out.println(i);
    }

    /**
     * 遍历一遍O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (target <= num) {
                index = i;
                break;
            } else if (target > nums[nums.length - 1]) {
                index = nums.length;
            }
        }
        return index;
    }

    /**
     * 二分查找 O(logN)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
