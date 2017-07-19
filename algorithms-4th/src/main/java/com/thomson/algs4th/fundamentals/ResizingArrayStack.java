package com.thomson.algs4th.fundamentals;

import java.util.Iterator;

/**
 * Algorithm 1.1 Pushdown (LIFO) stack (resizing array implementation)
 *
 * @author Thomson Tang
 * @version Created: 19/07/2017.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    @SuppressWarnings("unchecked")
    private Item[] items = (Item[]) new Object[1]; //Item类型的数组，存储元素
    private int N = 0; //元素的个数

    public ResizingArrayStack() {
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        //首先检查数组是否已满
        if (N == items.length) {
            resize(2 * items.length);
        }
        items[N++] = item;
    }

    public Item pop() {
        Item item = items[--N];
        items[N] = null;
        if (N > 0 && N == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        //此处也可以直接使用JDK自身的数组 copy 方法
//        System.arraycopy(items, 0, temp, 0, N);
        items = temp;
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return items[--i];
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> items = new ResizingArrayStack<>();
        items.push("spurs");
        items.push("lakers");
        items.push("cavs");
        String pop = items.pop();
        System.out.println("result: " + pop);
    }
}
