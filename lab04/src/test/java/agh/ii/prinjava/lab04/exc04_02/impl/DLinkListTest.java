package agh.ii.prinjava.lab04.exc04_02.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class  DLinkListTest {
    DLinkList<Integer> dLinkList;

    @BeforeEach
    void setUp() {
        dLinkList = new DLinkList<>();
    }

    @AfterEach
    void tearDown() {
        dLinkList = null;
    }


    /**
     * Test the addFirst operation of the list.
     * This test verifies that elements are correctly added to the beginning of the list
     * and that the order of elements is maintained.
     */
    @Test
    void testAddFirst() {
        dLinkList.addFirst(1);
        dLinkList.addFirst(2);
        assertEquals("2 1", dLinkList.toString());
    }

    /**
     * Test the addLast operation of the list.
     * This test verifies that elements are correctly added to the end of the list
     * and that the order of elements is maintained.
     */
    @Test
    void testAddLast() {
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        assertEquals("1 2", dLinkList.toString());
    }

    /**
     * Test the removeFirst operation of the list.
     * This test verifies that elements are correctly removed from the beginning of the list
     * and that the order of elements is maintained.
     */
    @Test
    void testRemoveFirst() {
        dLinkList.addFirst(1);
        dLinkList.addFirst(2);
        assertEquals(2, dLinkList.removeFirst());
        assertEquals(1, dLinkList.removeFirst());
    }


    /**
     * Test the removeLast operation of the list.
     * This test verifies that elements are correctly removed from the end of the list
     * and that the order of elements is maintained.
     */
    @Test
    void testRemoveLast() {
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        assertEquals(2, dLinkList.removeLast());
        assertEquals(1, dLinkList.removeLast());
    }

    /**
     * Test the numOfElems operation of the list.
     * This test verifies that the number of elements in the list is correctly returned.
     */
    @Test
    void testToString() {
        dLinkList.addFirst(10);
        dLinkList.addFirst(20);
        dLinkList.addFirst(30);
        assertEquals("30 20 10", dLinkList.toString());
    }
}
