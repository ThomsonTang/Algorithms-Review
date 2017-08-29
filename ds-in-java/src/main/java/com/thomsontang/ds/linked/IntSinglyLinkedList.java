package com.thomsontang.ds.linked;

/**
 * Singly linked list class to store integers.
 *
 * @author Thomson Tang
 * @version Created: 29/08/2017.
 */
public class IntSinglyLinkedList {
    protected IntNode head; // 头节点
    protected IntNode tail; // 尾节点

    public IntSinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add2Head(int element) {
        head = new IntNode(element, head);
        if (tail == null) {
            tail = head;
        }
    }

    public void add2Tail(int element) {
        if (!isEmpty()) {
            tail.next = new IntNode(element);
            tail = tail.next;
        } else {
            head = new IntNode(element);
            tail = head;
        }
    }

    public int deleteFromHead() {
        int element = head.info;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        return element;
    }

    public int deleteFromTail() {
        int element = tail.info;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            IntNode tmp;
            for (tmp = head; tmp.next != tail; tmp = tmp.next) ;
            tail = tmp;
            tail.next = null;
        }
        return element;
    }

    public void printAll() {
        for (IntNode node = head; node != null; node = node.next) {
            System.out.println(node.info);
        }
    }

    public boolean contains(int element) {
        IntNode node;
        for (node = head; node != null && node.info == element; node = node.next) ;
        return node != null;
    }

    public void delete(int element) {
        if (!isEmpty()) {
            if (head == tail && head.info == element) { // 只有一个节点
                head = null;
                tail = null;
            } else if (element == head.info) { // 刚好是头节点
                head = head.next;
            } else {
                IntNode prev;
                IntNode node;
                for (prev = head, node = head.next; node != null && node.info != element; prev = prev.next, node = node.next)
                    ;
                if (node != null) {
                    prev.next = node.next;
                    if (node == tail) {
                        tail = prev;
                    }
                }
            }
        }
    }
}
