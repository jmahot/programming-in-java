package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyStackDLLBImpl;

/**
 * Represents a generic stack interface.
 *
 * @param <E> the type of elements held in this stack
 */
public interface MyStack<E> {

    /**
     * Removes and returns the element at the top of this stack.
     *
     * @return the element at the top of this stack
     */
    E pop();

    /**
     * Pushes an element onto the top of this stack.
     *
     * @param x the element to be pushed onto this stack
     */
    void push(E x);

    /**
     * Checks if this stack is empty.
     *
     * @return true if this stack is empty, false otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    int numOfElems();


    /**
     * Retrieves, but does not remove, the element at the top of this stack.
     *
     * @return the element at the top of this stack
     */
    E peek();

    /**
     * Creates and returns a new instance of MyStack.
     *
     * @param <T> the type of elements held in the created stack
     * @return a new instance of MyStack
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
