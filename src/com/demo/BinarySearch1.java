package com.demo;

/**
 * 查找第一个值等于给定值的元素
 * 1,3,4,5,6,8,8,8,11,18
 * 找到第一个8
 *
 * @author liushuang 2019/5/31
 */
public class BinarySearch1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 8, 8, 8, 8, 11, 18};
        System.out.println(search(arr, 8));
    }

    public static int search(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int res = -1;
        while (left <= right) {
//            int mid = (left+right)/2;
            int mid = left + (right - left) / 2;
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                //对比前一行的数据.
                if (mid == 0 || arr[mid - 1] != value) {
                    res = mid;
                }
                right = mid - 1;

            }
        }

        return res;
    }
}
