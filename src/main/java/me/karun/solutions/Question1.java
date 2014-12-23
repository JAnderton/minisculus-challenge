package me.karun.solutions;

import java.util.stream.Collectors;

// http://minisculuschallenge.com/questions/14f7ca5f6ff1a5afb9032aa5e533ad95.html
public class Question1 implements Question {
    private final int wheelPosition = 6;

    @Override
    public String solve(final String question) {
        return question.chars()
                .map(cInt -> dataBank.indexOf(String.valueOf((char) cInt)))
                .map(index -> (index + wheelPosition + size) % size)
                .mapToObj(index -> dataBank.get(index))
                .collect(Collectors.joining());
    }
}
