package com.thomson.algs4th.fundamentals;

import java.util.Iterator;

/**
 * FIFO Queue
 *
 * This generic Queue implementation is based on a linked-list data structure. It can be used to create queues
 * containing any type of data.
 *
 * @author Thomson Tang
 * @version Created: 27/07/2017.
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first; // link to least recently added node
    private Node last; // link to most recently added node
    private int N; // number of items on the queue

    // nested class to define node
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null; // or: N == 0
    }

    public int size() {
        return N;
    }

    // add an item to the end of the list.
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    // remove item form the beginning of the list
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("spurs");
        queue.enqueue("lakers");
        queue.enqueue("cavs");

        for (String aQueue : queue) {
            System.out.println("dequeue: " + aQueue);
        }
    }
}
