package com.stack;

import java.util.Stack;

/**
 * 1-2-3
 * stack实现queue 2个stack来回倒腾
 * @author liushuang 2019/02/28 15:00
 */
public class QueueUsingStack {
    Stack<Integer> input = null;
    Stack<Integer> output = null;

    /** Initialize your data structure here. */
    public QueueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(input.empty()){
            input.push(x);
        }else {
            while(!input.empty()) {
                output.push(input.pop());
            }
            input.push(x);
            while (!output.empty()) {
                input.push(output.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return input.pop();
    }

    /** Get the front element. */
    public int peek() {
        return input.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty();
    }
}

/**
 * Your QueueUsingStack object will be instantiated and called as such:
 * QueueUsingStack obj = new QueueUsingStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
