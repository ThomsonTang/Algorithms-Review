package com.thomson.algs4th.fundamentals;

import java.util.Iterator;

/**
 * Algorithm 1.2 Pushdown stack (linked-list implementation)
 *
 * This generic Stack implementation is based on a linked-list data structure. It can be used to create stacks
 * containing any type of data.
 *
 * @author Thomson Tang
 * @version Created: 26/07/2017.
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first; // top of stack (most recently added node)
    private int N; // number of items

    // nested class to define nodes
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * Add an item to top of stack
     *
     * @param item the item
     */
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * Remove item from top of stack.
     *
     * @return the item.
     */
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("spurs");
        stack.push("lakers");
        stack.push("cavs");

        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println("pop: " + iterator.next());
        }

        System.out.println("size = " + stack.size());
        System.out.println("pop the item = [" + stack.pop() + "]");
    }
}
