package com.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author liushuang 2019/5/20
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        gen("", 0, 0, list, n);
        return list;
    }

    /**
     * 1.左括号随时可以加
     * 2.左右括号<=n
     * 3.左括号数 >= 右括号数
     * 无非是左右括号2选1.每一次都是2选1,通过if来选择一条路走下去,
     */
    public static void gen(String sub, int leftUsed, int rightUsed, List<String> list, int n) {
        if (leftUsed == n && rightUsed == n) {
            list.add(sub);
            return;
        }
        if (leftUsed < n) {
            gen(sub + "(", leftUsed + 1, rightUsed, list, n);
        }
        if (leftUsed > rightUsed) {
            gen(sub + ")", leftUsed, rightUsed + 1, list, n);
        }
    }
}
