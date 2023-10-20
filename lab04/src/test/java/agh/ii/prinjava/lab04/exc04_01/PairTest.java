package agh.ii.prinjava.lab04.exc04_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {

    @Test
    public void testPairConstructorAndGetters() {
        // Create a Pair with specific values
        Pair<Integer, String> pair = new Pair<>(1, "One");

        // Verify that the getters return the expected values
        assertEquals(1, pair.getFirst());
        assertEquals("One", pair.getSecond());
    }

    @Test
    public void testPairSetters() {
        // Create a Pair with initial values
        Pair<Integer, String> pair = new Pair<>(1, "One");
        // Modify the values using setters
        pair.setFirst(2);
        pair.setSecond("Two");

        // Verify that the setters correctly update the values
        assertEquals(2, pair.getFirst());
        assertEquals("Two", pair.getSecond());
    }

    @Test
    public void testPairToString() {
        // Create a Pair with specific values
        Pair<Integer, String> pair = new Pair<>(1, "One");

        // Verify that the toString method returns the expected string representation
        assertEquals("(1, One)", pair.toString());
    }

    @Test
    public void testPairEquals() {
        // Create two Pairs with the same and different values
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = new Pair<>(1, "One");
        Pair<Integer, String> pair3 = new Pair<>(2, "Two");

        // Verify that equals correctly identifies equality and inequality
        assertTrue(pair1.equals(pair2));
        assertFalse(pair1.equals(pair3));
    }

    @Test
    public void testPairHashCode() {
        // Create two Pairs with the same values
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = new Pair<>(1, "One");

        // Verify that hashCode generates the same value for equal objects
        assertEquals(pair1.hashCode(), pair2.hashCode());
    }

    @Test
    public void testPairClone() {
        // Create a Pair and clone it
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = pair1.clone();

        // Verify that the two objects have the same values
        assertTrue(pair1.equals(pair2));
        // Verify that the two objects are not the same instance in memory
        assertNotSame(pair1, pair2);
    }
}
