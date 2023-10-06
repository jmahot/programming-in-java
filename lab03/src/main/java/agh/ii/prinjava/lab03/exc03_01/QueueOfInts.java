package agh.ii.prinjava.lab03.exc03_01;

/** QueueOfInts is an interface for a queue of integers.
 */
public interface QueueOfInts {
    /** Add an integer to the end of the queue. */
    void enqueue(int x);

    /** Remove and return the integer from the front of the queue. */
    int dequeue();

    /** Check if the queue is empty. */
    boolean isEmpty();

    /** Get the number of elements in the queue. */
    int numOfElems();

    /** Peek at the integer at the front of the queue without removing it. */
    int peek();
}
