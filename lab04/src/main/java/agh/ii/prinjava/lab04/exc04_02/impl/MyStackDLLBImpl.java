package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;

/**
 * A Stack implementation based on a doubly linked list
 * @param <E> Type of elements in the stack
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private final DLinkList<E> elems = new DLinkList<>();
    private int size = 0;

    /**
     * Removes the element on the top of the stack and returns it.
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        return elems.removeFirst();
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param x the element to be pushed onto the stack
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
        size++;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int numOfElems() {
        return size;
    }

    /**
     * Peeks at the top element of the stack without removing it.
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E peek() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        E firstElem = elems.removeFirst();
        elems.addFirst(firstElem);
        return firstElem;
    }


    /**
     * Returns a string representation of the stack.
     *
     * @return a string representation of the stack
     */
    @Override
    public String toString() {
        return elems.toString();
    }
}
