package com.ls.list;

import java.util.Arrays;

/**
 * @author liushuang 2017/10/12
 */
public class SeqList<T> {

    protected Object[] element;

    protected int size;

    public SeqList() {
        this(5);
    }

    public SeqList(int length) {
        this.element = new Object[length];
    }

    public SeqList(T[] value) {
        this.element = value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) element[index];
        }
        return null;
    }

    /**
     * a0 -> a0
     * a1 -> a1
     * a2 -> x
     * a3 -> a2
     * ...   a3
     * ...   ...
     *       ...
     * 插入一个元素x,index =2.. 复制 0 ~1的数组. 插入x,然后a2,a3,...依次后移.
     */
    public void add(int index, T t) {
        //容错.
        if(index < 0) {
            index = 0;
        }
        if(index > size) {
            index = size;
        }

        Object[] source = this.element;
        if (this.element.length == size) {//如果满了就扩容.
            this.element = new Object[source.length * 2];
            for (int j = 0; j < index; j++) { // 复制 0 ~ index-1 之前值到新的数组.
                this.element[j] = source[j];
            }
        }
        for (int j = index; j <= size - 1; j++) { //size扩容后的长度了.
            element[j + 1] = source[j];
        }
        this.element[index] = t;
        this.size++;
    }

    @Override
    public String toString() {
        return "SeqList{" +
                "element=" + Arrays.toString(element) +
                ", size=" + size +
                '}';
    }
}
