package com.stack;

/**
 * @author liushuang 2019/03/01 16:37
 */
public class KthLargestTest {
    public static void main(String[] args) {
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        int add = kthLargest.add(3);// returns 4
        int add1 = kthLargest.add(5);// returns 5
        int add2 = kthLargest.add(10);// returns 5
        int add3 = kthLargest.add(9);// returns 8
        int add4 = kthLargest.add(4);// returns 8
        System.out.println(add);
        System.out.println(add1);
        System.out.println(add2);
        System.out.println(add3);
        System.out.println(add4);
    }
}
