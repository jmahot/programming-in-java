package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;

/**
 * A Queue implementation based on a doubly linked list
 * @param <E> Type of elements in the queue
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {

    private final DLinkList<E> elems = new DLinkList<>();
    private int size = 0;

    /**
     * Adds an element to the end of the queue.
     *
     * @param x the element to be added to the queue
     */
    @Override
    public void enqueue(E x) {
        elems.addLast(x);
        size++;
    }

    /**
     * Removes and returns the element at the beginning of the queue.
     *
     * @return the first element of the queue
     * @throws IllegalStateException if the queue is empty
     * */
    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }

        size--;
        return elems.removeFirst();

    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return size;
    }

    /**
     * Peeks at the first element of the queue without removing it.
     *
     * @return the first element of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public E peek() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        E firstElem = elems.removeFirst();
        elems.addFirst(firstElem);
        return firstElem;
    }

    /**
     * Returns a string representation of the queue.
     *
     * @return a string representation of the queue
     */
    @Override
    public String toString() {
        return elems.toString();
    }
}
