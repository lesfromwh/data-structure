package com.rests;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 *
 * @author liushuang 2019/5/14
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] ints = {2, 2, 1, 1, 1, 2, 2};
        int i = majorityElement(ints);
        System.out.println(i);
    }

    //一层循环O(n)=n
    //leetCode只超过百分之30
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            if (hashMap.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}
