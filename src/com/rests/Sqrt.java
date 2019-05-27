package com.rests;

/**
 * leetcode 69 x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * @author liushuang 2019/5/27
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    /**
     * 二分查找法
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;
        int res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == x / mid) {
                return mid;
            }
            if (mid < x / mid) {
                left = mid + 1;
                res = mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            }
        }
        return res;
    }

    /**
     * 牛顿迭代法.
     */


    /**
     * double精度,二分法.
     * 要确定精度,不然无限循环了.
     */
    public static double mySqrt2(int x, int jd) {
        if (x == 0 || x == 1) {
            return x;
        }
        double left = 1;
        double right = x;
        double res = 0;

        while (left <= right) {
            double mid = (left + right) / 2;
            if (mid == x / mid) {
                return mid;
            }
            if (mid < x / mid) {
                left = mid;
                res = mid;
            } else if (mid > x / mid) {
                right = mid;
            }
        }
        return res;
    }
}
