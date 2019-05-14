package com.recursion;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * @author liushuang 2019/5/13
 */
public class Pow {

    public static void main(String[] args) {
//        double v = myPow(-1, -2147483648);
//        System.out.println(v);

//        System.out.println(5 >> 1);
//        System.out.println(4 >> 2);
//        System.out.println(2 >> 1);
//        System.out.println(2 << 3);
//        System.out.println(4 & 1);
//        System.out.println(5 & 1);

        double v = myPow3(-1, -2147483648);
        System.out.println(v);
    }

    /**
     * O(n)有点慢了
     */
    public static double myPow1(double x, int n) {
        if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1;
        }
        return (n > 0 ? x : 1 / x) * myPow1(n > 0 ? x : 1 / x, Math.abs(n) - 1);
    }

    /**
     * 采用分治
     * x*x*x*x*x.....=y (x^n=y)
     * y = x^(n/2)*x^(n/2)
     * y= x^(n/4)*x^(n/4)*x^(n/4)*x^(n/4)
     * ...
     * y= x^(n/2^k)*x^(n/2^k)*...   直到 n/2^k = 1  n = 2^k , k= log2的N
     * 所以O(n)=logN
     * 注意一下n的奇偶
     * <p>
     * 1.00000
     * -2147483648
     */
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            // -2^31~ 2^31-1   -2^31最小的时候直接-n会溢出
            return 1 / (x * myPow(x, -(n + 1)));
        } else if (n % 2 != 0) {
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2);
    }

    public static double myPow3(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                x = 1 / (x * x);
            } else {
                n = -n;
                x = 1 / x;
            }
        }
        double pow = 1;
        while (n > 0) {
            // 如果n是奇数
            // n= 9  9->4->2->1
            // n=8   8->4->2->1
            // 最后都会变成1 把x赋值给pow
            // 奇数就是开头多乘以一个x.
            if ((n & 1) == 1) {
                pow *= x;
            }
            x *= x;
            n >>= 1;
        }
        return pow;
    }
}
