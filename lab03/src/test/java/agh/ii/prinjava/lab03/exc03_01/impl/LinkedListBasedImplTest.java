package agh.ii.prinjava.lab03.exc03_01.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListBasedImplTest {

    private LinkedListBasedImpl queue;

    @BeforeEach
    public void setUp() {
        queue = new LinkedListBasedImpl();
    }

    @Test
    @DisplayName("Test enqueue and dequeue")
    public void testEnqueueAndDequeue() {
        queue.enqueue(55);
        queue.enqueue(99);
        queue.enqueue(123);

        assertEquals(55, queue.dequeue());
        assertEquals(99, queue.dequeue());
        assertEquals(123, queue.dequeue());
    }

    @Test
    @DisplayName("Test isEmpty")
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.enqueue(42);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Test numOfElems")
    public void testNumOfElems() {
        assertEquals(0, queue.numOfElems());

        queue.enqueue(7);
        queue.enqueue(14);

        assertEquals(2, queue.numOfElems());

        queue.dequeue();
        assertEquals(1, queue.numOfElems());
    }

    @Test
    @DisplayName("Test peek")
    public void testPeek() {
        queue.enqueue(66);
        assertEquals(66, queue.peek());

        queue.enqueue(77);
        assertEquals(66, queue.peek());

        queue.dequeue();
        assertEquals(77, queue.peek());
    }
}
