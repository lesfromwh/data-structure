package com.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode 703
 *
 * @author liushuang 2019/03/01 16:11
 */
public class KthLargest {

//    int k = 0;
//    ArrayList<Integer> list = null;
//
//    public KthLargest(int k, int[] nums) {
//        this.k = k;
//        list = new ArrayList<Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            list.add(nums[i]);
//        }
//    }
//
//    public int add(int val) {
//        list.add(val);
//        Collections.sort(list);
//        Collections.reverse(list);
//        return list.get(k - 1);
//    }

    final int k;
    final PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(heap.size()< k) {
            heap.offer(val);
        }else if(heap.peek()< val) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
