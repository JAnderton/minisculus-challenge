package me.karun.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Question4Test {

    @Test
    public void testSolve() throws Exception {
        final String input = "WZyDsL3u'0TfxP06RtSSF 'DbzhdyFIAu2 zF f5KE\"SOQTNA8A\"NCKPOKG5D9GSQE'M86IGFMKE6'K4pEVPK!bv83I";
        final String expectedResult = "The rockets will strike at coordinates 49.977984 7.9257857 422979.83 5536735.81 on Oct. 7th";
        final String actualAnswer = new Question4().solve(input);

        assertEquals(expectedResult, actualAnswer);
    }
}