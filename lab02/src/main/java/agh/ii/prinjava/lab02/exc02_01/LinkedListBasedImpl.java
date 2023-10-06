package agh.ii.prinjava.lab02.exc02_01;

/**
 * A linked list-based implementation of the StackOfInts interface that uses a linked list to store integers.
 */
public class LinkedListBasedImpl implements StackOfInts {

    private static class Node {
        int elem;
        Node next;

        Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Node first = null;
    private int numOfElems = 0;

    /**
     *     The pop method removes and returns the top element from the stack (the first node in the linked list). It checks if the stack is empty and throws an exception if it is.
     *     It retrieves the value of the first node (first.elem), updates the first reference to point to the next node, and decrements numOfElems.
     */
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int popped = first.elem;
        first = first.next;
        numOfElems--;
        return popped;
    }

    /**
     *  The push method adds an integer x to the top of the stack by creating a new node (newNode) and inserting it at the beginning of the linked list.
     *  It updates the first reference to point to the new node and increments numOfElems.
     */
    @Override
    public void push(int x) {
        Node newNode = new Node(x, first);
        first = newNode;
        numOfElems++;
    }

    /**
     *  The numOfElems method returns the current number of elements in the stack, which is stored in the numOfElems variable.
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     * The peek method returns the top element of the stack without removing it. It checks if the stack is empty and throws an exception if it is.
     * It retrieves the value of the first node (first.elem).
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return first.elem;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return numOfElems == 0;
    }
}
