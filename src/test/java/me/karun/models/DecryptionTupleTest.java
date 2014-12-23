package me.karun.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecryptionTupleTest {

    @Test
    public void testIsValidSolution() throws Exception {
        final boolean expectedSolution = true;
        final boolean actualSolution = new DecryptionTuple(0, 0, "We must defend..").isValidSolution();

        assertEquals(expectedSolution, actualSolution);
    }

    @Test
    public void testIsValidNotSolution() throws Exception {
        final boolean expectedSolution = false;
        final boolean actualSolution = new DecryptionTuple(0, 0, "Blah Blah").isValidSolution();

        assertEquals(expectedSolution, actualSolution);
    }

    @Test
    public void testToString() throws Exception {
        final String expectedSolution = "{1, 2} => Blah Blah";
        final String actualSolution = new DecryptionTuple(1, 2, "Blah Blah").toString();

        assertEquals(expectedSolution, actualSolution);
    }
}