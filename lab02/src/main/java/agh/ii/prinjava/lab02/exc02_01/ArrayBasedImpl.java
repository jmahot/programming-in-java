package agh.ii.prinjava.lab02.exc02_01;

/**
 *      An array-based implementation of the StackOfInts interface that uses an array to store integers.
 *      It provides a basic stack data structure where elements are pushed onto the stack and popped from the top of the stack.
 */
public class ArrayBasedImpl implements StackOfInts {

    private static final int INITIAL_CAPACITY = 10; // Initial capacity of the array
    private int[] elements; // Array to store the elements
    private int size; // Current number of elements in the stack

    /**
     *     Constructs an empty array-based stack with an initial capacity.
     */
    public ArrayBasedImpl() {
        elements = new int[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     *     The pop method removes and returns the top element from the stack. It first checks if the stack is empty and throws an exception if it is.
     *     It retrieves the top element from the elements array, decrements the size to remove it from the stack, and returns the popped element.
     */
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int popped = elements[size - 1];
        size--;
        return popped;
    }

    /**
     *     The push method adds an integer x to the top of the stack.
     *     It first calls the ensureCapacity method to ensure that the array has enough capacity to accommodate the new element.
     *     Then, it adds the element to the top of the stack and increments the size.
     */
    @Override
    public void push(int x) {
        ensureCapacity();
        elements[size] = x;
        size++;
    }

    /**
     *      The numOfElems method returns the current number of elements in the stack, which is stored in the size variable.
     */
    @Override
    public int numOfElems() {
        return size;
    }

    /**
     *      The peek method returns the top element of the stack without removing it. It checks if the stack is empty and throws an exception if it is.
     *      It retrieves and returns the top element from the elements array.
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[size - 1];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Ensures that the array has enough capacity to accommodate new elements.
     * If not, it doubles the array size.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            int[] newElements = new int[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
}
