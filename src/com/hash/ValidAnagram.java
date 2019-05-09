package com.hash;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author liushuang 2019/3/26
 */
public class ValidAnagram {

    public static void main(String[] args) {
        boolean anagram = isAnagram2("ab", "a");
        System.out.println(anagram);
    }


    //map插入O(1) for是O(n) 整体是O(1)
    public static boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (Character s1 : chars1) {
            map1.put(s1, map1.containsKey(s1) ? map1.get(s1) + 1 : 1);
        }
        for (Character s2 : chars2) {
            map2.put(s2, map2.containsKey(s2) ? map2.get(s2) + 1 : 1);
        }
        return map1.equals(map2);
    }

    //思路二:可以对字符串进行排序,然后比较他们是否相同.

    //思路三:自己用数组实现一个hash函数

    public static boolean isAnagram2(String s, String t) {
        if (s.length() == 0) {
            return  true;
        }
        if (s.length() != t.length()) {
           return false;
        }
        int[] count = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            //差值作为hash值,进行累计
            count[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < length; i++) {
            count[t.charAt(i) - 'a'] -= 1;
            if (count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
