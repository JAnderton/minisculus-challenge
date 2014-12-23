package me.karun.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseTest {

    @Test
    public void testGetMessage() throws Exception {
        final String expectedResult = "abc";
        final String actualResult = new Response(1, expectedResult).getMessage();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testToString() throws Exception {
        final String expectedResult = "{\"code\":1,\"message\":\"abc\"}";
        final String actualResult = new Response(1, "abc").toString();

        assertEquals(expectedResult, actualResult);
    }
}