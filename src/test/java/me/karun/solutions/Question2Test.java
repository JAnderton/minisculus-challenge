package me.karun.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question2Test {

    @Test
    public void testSolve() throws Exception {
        final String input = "abc3,";
        final String expectedResult = "def6'";
        final String actualAnswer = new Question2().solve(input);

        assertEquals(expectedResult, actualAnswer);
    }
}