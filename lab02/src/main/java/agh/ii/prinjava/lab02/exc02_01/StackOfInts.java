package agh.ii.prinjava.lab02.exc02_01;

/**
 * Interface representing a stack of integers.
 */
public interface StackOfInts {

    /***
     * @return The top element from the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    int pop();

    /***
     * @param x Pushes the integer onto the top of the stack.
     */
    void push(int x);

    /***
     * @return The number of elements in the stack.
     */
    int numOfElems();

    /***
     * @return The top element from the stack without removing it.
     * @throws IllegalStateException if the stack is empty.
     */
    int peek();

    boolean isEmpty();
}

