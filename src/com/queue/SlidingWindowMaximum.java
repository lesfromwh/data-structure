package com.queue;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author liushuang 2019/3/8
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] ints = {1,3,1,2,0,5};
        int[] ints1 = maxSlidingWindow(ints, 3);
        System.out.println(Arrays.toString(ints1));
    }


    //O(n²)
    //nums = [1,3,-1,-3,5,3,6,7], and k = 3
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length - k + 1 < 0 || nums.length == 0) {
//            return new int[]{};
//        } else {
//            int[] arr = new int[nums.length - k + 1];
//            for (int i = 0; i < nums.length - k + 1; i++) {
//                ArrayList<Integer> list = new ArrayList<>();
//                int j = k;
//                while (j-- != 0) {
//                    list.add(nums[i + j]);
//                }
//                int max = max(list);
//                arr[i] = max;
//            }
//            return arr;
//        }
//    }
//
//    public static int max(ArrayList<Integer> list) {
//        int max = Integer.MIN_VALUE;
//        for (Integer integer : list) {
//            if (max < integer.intValue()) {
//                max = integer;
//            }
//        }
//        return max;
//    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //随着窗口的移动,清除最左边的索引
            if (i >= k && i - k + 1 > deque.peek()) {
                deque.remove();
            }
            //目标是为了保持队列第一个元素是最大值(最大值对应的索引值).
            //如果当前元素比上一个窗口的最后一个元素大.就清除最后一个.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            //直接比较first,某些情况下不行.
            //例如{1,3,1,2,0,5},k=3 .   131([1,2])=> 312([123])=> 120([234]) 最左边已经不是最大了.
//            while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) {
//                deque.removeFirst();
//            }
            deque.add(i);
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
        return res;
    }
}
