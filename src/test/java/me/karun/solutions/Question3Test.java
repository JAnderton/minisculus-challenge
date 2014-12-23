package me.karun.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question3Test {

    @Test
    public void testSolve() throws Exception {
        final String input = "The white cliffs of Alghero are visible at night";
        final String expectedResult = "JMl0kBp?20QixoivSc.2\"vvmls8KOk\"0jA,4kgt0OmUb,pm.";
        final String actualAnswer = new Question3().solve(input);

        assertEquals(expectedResult, actualAnswer);
    }
}