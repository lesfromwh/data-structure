package com.arr;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 三数之和
 * 存在a+b+c=0
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author liushuang 2019/5/9
 */

public class Leetcode15 {

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum3(nums);
        System.out.println(lists);
    }

    //a+b+c=0   c= -(a+b)
    //TODO set 去重 没有解决 [0,0,0]问题
    public static List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            hashSet.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                ArrayList<Integer> innerList = new ArrayList<>();
                int numI = nums[i];
                int numJ = nums[j];
                hashSet.remove(numI);
                hashSet.remove(numJ);
                if (hashSet.contains(-1 * (numI + numJ)) && i != j) {
                    innerList.add(-1 * (numI + numJ));
                    innerList.add(numI);
                    innerList.add(numJ);
                    innerList.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    if (!list.contains(innerList)) {
                        list.add(innerList);
                    }
                }
                hashSet.add(numI);
                hashSet.add(numJ);
            }

        }
        return list;
    }

    // 超时了
    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            hashMap.put(i, num);
        }

        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                ArrayList<Integer> innerList = new ArrayList<>();
                int numI = nums[i];
                int numJ = nums[j];
                int c = -1 * (numI + numJ);
                Integer cIndex = hashMap.get(c);
                Collection<Integer> values = hashMap.values();
                if (values.contains(c) && i != j && cIndex != i && cIndex != j) {
                    innerList.add(numI);
                    innerList.add(numJ);
                    innerList.add(c);
                    innerList.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    if (!list.contains(innerList)) {
                        list.add(innerList);
                    }
                }
            }
        }
        return list;
    }

    /**
     * a+b+c=0 a=-(b+c)
     * 先对数组排序 那么就是从小->大
     * 确定a的位置  开始for循环 (需要去重)
     * b+c 两个索引往中间靠近,只有一边的索引移动.(通过a+b+c>0或<0来决定)
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        // N*log n
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        //排序以后从小到大
        for (int i = 0; i < nums.length - 2; i++) {
            //TODO 在leetcode上运行 加了这个if之后是超过百分之90%,没加是超过百分之8%
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int bIndex = i + 1;
            int cIndex = nums.length - 1;

            while (bIndex < cIndex) {
                int b = nums[bIndex];
                int c = nums[cIndex];
                if (a + b + c > 0) {
                    //c的index 左移动
                    cIndex--;
                    continue;
                } else if (a + b + c < 0) {
                    //b的index 右移动
                    bIndex++;
                    continue;
                } else {
                    List<Integer> innerList = Arrays.asList(a, b, c);
                    list.add(innerList);
                    while (bIndex < cIndex && nums[bIndex] == nums[bIndex + 1]) {
                        bIndex++;
                    }
                    while (bIndex < cIndex && nums[cIndex] == nums[cIndex - 1]) {
                        cIndex--;
                    }
                    bIndex++;
                    cIndex--;
                    continue;
                }
            }
        }
        return list;
    }
}
