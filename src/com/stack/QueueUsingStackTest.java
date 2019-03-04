package com.stack;

/**
 * @author liushuang 2019/02/28 15:11
 */
public class QueueUsingStackTest {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }
}
