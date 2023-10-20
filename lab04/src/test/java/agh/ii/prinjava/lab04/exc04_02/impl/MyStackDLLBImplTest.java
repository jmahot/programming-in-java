package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();

    /**
     * Test the push operation of the stack.
     * This test verifies that elements are correctly pushed onto the stack
     * and that the order of elements is maintained with the latest element at the top.
     */
    @Test
    void testPush() {
        stackOfInts.push(1);
        System.out.println("New element added !");
        System.out.println("My Stack: " + stackOfInts.toString());
        assertEquals("1", stackOfInts.toString());

        stackOfInts.push(2);
        System.out.println("New element added !");
        System.out.println("My Stack: " + stackOfInts.toString());
        assertEquals("2 1", stackOfInts.toString());

        stackOfInts.push(99);
        System.out.println("New element added !");
        System.out.println("My Stack: " + stackOfInts.toString());
        assertEquals("99 2 1", stackOfInts.toString());

    }

    /**
     * Test the pop operation of the stack.
     * This test verifies that elements are correctly popped from the top of the stack
     * and that the order of elements is maintained.
     */
    @Test
    void testPop() {
        stackOfInts.push(1);
        stackOfInts.push(2);
        assertEquals("2 1", stackOfInts.toString());
        stackOfInts.pop();
        assertEquals("1", stackOfInts.toString());
        stackOfInts.pop();
        assertEquals("", stackOfInts.toString());
    }

    /**
     * Test the numOfElems operation of the stack.
     * This test verifies that the number of elements in the stack is correctly returned.
     */
    @Test
    void testNumOfElems() {
        assertEquals(0, stackOfInts.numOfElems());
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.numOfElems());
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.numOfElems());
    }

    /**
     * Test the peek operation of the stack.
     * This test verifies that the element at the top of the stack is correctly returned.
     */
    @Test
    void testPeek() {
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.peek());
        System.out.println("My Stack: " + stackOfInts.toString());
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek());
        System.out.println("My Stack: " + stackOfInts.toString());
    }

    /**
     * Test the toString operation of the stack.
     * This test verifies that the elements in the stack are correctly returned as a string.
     */
    @Test
    void testToString() {
        stackOfInts.push(10);
        stackOfInts.push(20);
        stackOfInts.push(30);
        assertEquals("30 20 10", stackOfInts.toString());
    }
}
