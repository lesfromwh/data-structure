package com.stack;

/**
 * @author liushuang 2019/03/01 15:41
 */
public class StackUsingQueueTest {
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int top = stack.top();

        System.out.println(top);
    }
}
