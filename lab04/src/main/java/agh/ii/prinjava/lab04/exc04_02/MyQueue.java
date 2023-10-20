package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyQueueDLLBImpl;

/**
 * Represents a generic queue interface.
 *
 * @param <E> the type of elements held in this queue
 */
public interface MyQueue<E> {

    /**
     * Inserts the specified element into this queue.
     *
     * @param x the element to be inserted
     */
    void enqueue(E x);

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of this queue
     */
    E dequeue();

    /**
     * Checks if this queue is empty.
     *
     * @return true if this queue is empty, false otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the element at the front of this queue.
     *
     * @return the element at the front of this queue
     */
    E peek();

    /**
     * Creates and returns a new instance of MyQueue.
     *
     * @param <T> the type of elements held in the created queue
     * @return a new instance of MyQueue
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
