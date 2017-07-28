package com.thomson.algs4th.fundamentals;

import java.util.Iterator;

/**
 * Algorithm 1.4 Bag
 *
 * This Bag implementation maintains a linked list of the items provided in calls to {@code add()}.
 *
 * @author Thomson Tang
 * @version Created: 28/07/2017.
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first; // first node in list

    class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
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
        Bag<String> bag = new Bag<>();
        bag.add("spurs");
        bag.add("lakers");
        bag.add("cavs");

        for (String item : bag) {
            System.out.println("[" + item + "]");
        }
    }
}
