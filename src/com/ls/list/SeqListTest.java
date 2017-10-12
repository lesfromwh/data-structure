package com.ls.list;

/**
 * @author liushuang 2017/10/12
 */
public class SeqListTest {
    public static void main(String[] args) {
        SeqList<String> list = new SeqList<>();
        list.add(0,"0");
        list.add(1,"1");
        list.add(2,"2");
        list.add(3,"3");
        list.add(4,"4");
        list.add(6,"2!");
        System.out.println(list);

    }
}
