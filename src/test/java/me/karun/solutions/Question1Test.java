package me.karun.solutions;

import org.junit.Test;
import static org.junit.Assert.*;


public class Question1Test {

    @Test
    public void testSolve() throws Exception {
        final String input = "abc!";
        final String expectedResult = "ghi2";
        final String actualAnswer = new Question1().solve(input);

        assertEquals(expectedResult, actualAnswer);
    }
}