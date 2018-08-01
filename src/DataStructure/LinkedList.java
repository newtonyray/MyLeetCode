package DataStructure;

import java.util.List;

public class LinkedList<E> {
    //fields
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    //constructor
    public LinkedList() {
        head = null; //still need to instantiate?
        tail = null; //still need to instantiate?
        size = 0;
    }

    //methods
    public void addHead(E e) {
        if (e == null) throw new IllegalArgumentException();
        if (size == 0) head = tail = new ListNode<E>(e);
        else {
            ListNode<E> newHead = new ListNode<E>(e);
            newHead.next = head;
            head.prev = newHead; //don't forget to set prev
            head = newHead;
        }
        size++;
    }

    public void addTail(E e) {
        if (e == null) throw new IllegalArgumentException();
        if (size == 0) head = tail = new ListNode<E>(e);
        else {
            ListNode<E> newTail = new ListNode<E>(e);
            tail.next = newTail;
            newTail.prev = tail; //don't forget to set prev
            tail = newTail;
        }
        size++;
    }

    public void add(E e) {
        addTail(e);
    }

    public ListNode<E> remove(E e) {
        return removeTail(e);
    }

    public ListNode<E> removeHead(E e) {
        if (e == null) throw new IllegalArgumentException();
        if (size == 0) return null;
        ListNode res = head;
        head = head.next;
        head.prev = null; //don't forget to set prev to null after head removal
        size--;
        return res;
    }

    public ListNode<E> removeTail(E e) {
        if (e == null) throw new IllegalArgumentException();
        ListNode res = null;
        if (size == 0) return res;
        tail = tail.prev;
        tail.next = null; //don't forget to set next to null after head removal
        size--;
        return res;
    }


    public int size() {
        return size;
    }




    class ListNode<E> {
        E val;
        ListNode<E> next;
        ListNode<E> prev;

        ListNode(E e) {
            val = e;
            next = null; //still need to instantiate to null
            prev = null; //still need to instantiate to null
        }

        //overloading
        ListNode() {
            val = null;
            next = null;
            prev = null;
        }
    }
}
