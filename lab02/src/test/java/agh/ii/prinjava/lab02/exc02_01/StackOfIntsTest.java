package agh.ii.prinjava.lab02.exc02_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackOfIntsTest {

    @Test
    public void testLinkedListBasedStack() {
        StackOfInts stack = new LinkedListBasedImpl();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.numOfElems());

        stack.push(10);
        System.out.println("Pushed: 10");
        stack.push(20);
        System.out.println("Pushed: 20");
        stack.push(30);
        System.out.println("Pushed: 30");

        assertFalse(stack.isEmpty());
        assertEquals(3, stack.numOfElems());
        assertEquals(30, stack.peek());

        System.out.println("Popping elements:");
        while (!stack.isEmpty()) {
            int element = stack.pop();
            System.out.println("Popped: " + element);
        }

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testArrayBasedStack() {
        StackOfInts stack = new ArrayBasedImpl();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.numOfElems());

        stack.push(5);
        System.out.println("Pushed: 5");
        stack.push(15);
        System.out.println("Pushed: 15");
        stack.push(25);
        System.out.println("Pushed: 25");

        assertFalse(stack.isEmpty());
        assertEquals(3, stack.numOfElems());
        assertEquals(25, stack.peek());

        System.out.println("Popping elements:");
        while (!stack.isEmpty()) {
            int element = stack.pop();
            System.out.println("Popped: " + element);
        }

        assertTrue(stack.isEmpty());
    }
}
