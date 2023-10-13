package agh.ii.prinjava.lab03.exc03_01;

/** QueueOfInts is an interface for a queue of integers.
 */
public interface QueueOfInts {
    /** @param x Add an integer to the end of the queue. */
    void enqueue(int x);

    /** @return the integer removed from the front of the queue. */
    int dequeue();

    /** Check if the queue is empty.
     * @return true if the queue is empty and if not, it returns false.*/
    boolean isEmpty();

    /** @return The number of elements in the queue. */
    int numOfElems();

    /** Peek at the integer at the front of the queue without removing it.
     * @return this integer. */
    int peek();
}
