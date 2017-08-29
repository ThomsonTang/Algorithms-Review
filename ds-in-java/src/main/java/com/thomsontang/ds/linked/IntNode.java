package com.thomsontang.ds.linked;

/**
 * A node in a integer singly linked list class.
 *
 * @author Thomson Tang
 * @version Created: 29/08/2017.
 */
public class IntNode {
    public int info;
    public IntNode next;

    public IntNode(int info) {
        this(info, null);
    }

    public IntNode(int info, IntNode next) {
        this.info = info;
        this.next = next;
    }
}
