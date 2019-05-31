package com.rests;

/**
 * Search in Rotated Sorted numsay 搜索选择排序数组
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author liushuang 2019/5/31
 */
public class LeetCode33 {
    //6701245

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int search = search(nums, 6);
        System.out.println(search);
    }

    /**
     * 整体思路：先用二分法找出最小值，也是那个分割点,例如 [4,5,6,7,0,1,2]，我们找出数字 0；
     * <p>
     * 接下来判断 target 是在分割点的左边还是右边;
     * <p>
     * 最后再使用一次二分法找出 target 的位置. 所以时间复杂度为：O(logn)O(logn)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int split = left;
        // 0~split,  split~length-1
        left = 0;
        right = nums.length - 1;
        if (target >= nums[split] && target <= nums[right]) {
            left = split;
        } else {
            right = split - 1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
