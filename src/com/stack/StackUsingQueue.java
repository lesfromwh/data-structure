package com.stack;

import java.util.LinkedList;

/**
 * leetcode 223
 * @author liushuang 2019/03/01 15:11
 */
public class StackUsingQueue {

    LinkedList<Integer> link1 = null;
    LinkedList<Integer> link2 = null;

    /** Initialize your data structure here. */
    public StackUsingQueue() {
        link1 = new LinkedList<Integer>();
        link2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        link2.add(x);
        while (!link1.isEmpty()) {
            Integer first = link1.removeFirst();
            link2.add(first);
        }
        while (!link2.isEmpty()) {
            Integer first = link2.removeFirst();
            link1.add(first);
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return link1.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return link1.getFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return link1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
