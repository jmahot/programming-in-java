package agh.ii.prinjava.lab01.lst01_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloEncapsulationTest {

    @BeforeEach
    void setUp() {
        System.out.println("HelloEncapsulationTest.setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("HelloEncapsulationTest.tearDown...");
    }

    void testGetPropVal() {
        HelloEncapsulation enDemo = new HelloEncapsulation(12);

        int propVal = enDemo.getPropVal();

        assertEquals(12, propVal);
    }

    void testSetPropVal() {
        HelloEncapsulation enDemo = new HelloEncapsulation(3);

        enDemo.setPropVal(12);
        int propVal = enDemo.getPropVal();

        assertEquals(12, propVal);
    }

    void testIsEncapsulated() {
        HelloEncapsulation enDemo = new HelloEncapsulation(3);

        boolean encapsulated = enDemo.isEncapsulated();

        assertTrue(encapsulated);
    }
}