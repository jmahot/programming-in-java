package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {

    MyQueue<Integer> queueOfInts = MyQueue.create();

    /**
     * Test the enqueue operation of the queue.
     * This test verifies that elements are correctly added to the end of the queue
     * and that the order of elements is maintained.
     */
    @Test
    void testEnqueue() {
        queueOfInts.enqueue(1);
        System.out.println("New element added in queue !\n" + queueOfInts.toString());
        assertEquals("1", queueOfInts.toString());
        queueOfInts.enqueue(2);
        System.out.println("New element added in queue !\n" + queueOfInts.toString());
        assertEquals("1 2", queueOfInts.toString());
    }


    /**
     * Test the dequeue operation of the queue.
     * This test verifies that elements are correctly removed from the front of the queue
     * and that the order of elements is maintained.
     */
    @Test
    void testDequeue() {
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        queueOfInts.enqueue(4);
        System.out.println("New elements added in queue !\n" + queueOfInts.toString());
        assertEquals("1 2 3 4", queueOfInts.toString());
        queueOfInts.dequeue();
        System.out.println("Element removed from queue !\n" + queueOfInts.toString());
        assertEquals("2 3 4", queueOfInts.toString());
    }

    /**
     * Test the numOfElems operation of the queue.
     * This test verifies that the number of elements in the queue is correctly returned.
     */
    @Test
    void testNumOfElems() {
        assertEquals(0, queueOfInts.numOfElems());

        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        queueOfInts.enqueue(4);

        System.out.println(queueOfInts.toString());
        System.out.println("Number of elements in queue: " + queueOfInts.numOfElems());
        assertEquals(4, queueOfInts.numOfElems());

        System.out.println("Removing 2 elements from queue...");
        for (int i = 0; i < 2; i++) {
            queueOfInts.dequeue();
        }

        System.out.println(queueOfInts.toString());
        System.out.println("Number of elements in queue: " + queueOfInts.numOfElems());
        assertEquals(2, queueOfInts.numOfElems());
    }

    /**
     * Test the peek operation of the queue.
     * This test verifies that the element at the front of the queue is correctly returned.
     */
    @Test
    void testPeek() {
        queueOfInts.enqueue(1);
        assertEquals(1, queueOfInts.peek());
        queueOfInts.enqueue(2);
        assertEquals(1, queueOfInts.peek());
    }


    /**
     * Test the toString operation of the queue.
     * This test verifies that the elements in the queue are correctly returned as a string.
     */
    @Test
    void testToString() {
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        queueOfInts.enqueue(4);
        assertEquals("1 2 3 4", queueOfInts.toString());
    }

}
