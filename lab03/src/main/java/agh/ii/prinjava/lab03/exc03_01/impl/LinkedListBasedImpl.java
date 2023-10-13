package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

public class LinkedListBasedImpl implements QueueOfInts {
    private Node first = null;
    private Node last = null;
    private int numOfElems = 0;

    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x, null, last);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        numOfElems++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int front = first.elem;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        numOfElems--;
        return front;
    }

    @Override
    public boolean isEmpty() {
        return numOfElems == 0;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return first.elem;
    }

    private static class Node {
        int elem;
        Node next;
        Node prev;

        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }
}
