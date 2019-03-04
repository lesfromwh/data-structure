package com.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * leetcode 20
 *
 * @author liushuang 2019/02/28 11:15
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {

    public static void main(String[] args) {
        boolean valid = isValid("(())[]{}()");
        System.out.println(valid);
    }

    /**
     * 放到栈里面()[]{}
     * 1. (
     * 2. () 匹配成功 然后清除栈
     * 3. {
     * 4. } 匹配陈宫 然后清除栈
     * 5. 同理,最后看栈是否被清空.如果中间出现不匹配的情况直接false
     *
     * @return
     */
    public static boolean isValid(String s) {
        HashMap hashMap = new HashMap<String, String>();
        hashMap.put(")", "(");
        hashMap.put("}", "{");
        hashMap.put("]", "[");

        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c :chars) {

            //如果不是右括号
            if (!hashMap.containsKey(String.valueOf(c))) {
                stack.push(String.valueOf(c));
            } else if (stack.empty() || !stack.pop().equals(hashMap.get(String.valueOf(c)))) {
                return false;
            }
        }
        return stack.empty();
    }

}
