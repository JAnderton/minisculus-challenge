package me.karun.solutions;

import java.util.stream.Collectors;

// http://minisculuschallenge.com/questions/2077f244def8a70e5ea758bd8352fcd8.html
public class Question2 implements Question {
    private final int wheel1Position = 9;
    private final int wheel2Position = 3;

    @Override
    public String solve(final String question) {
        return question.chars()
                .map(cInt -> dataBank.indexOf(String.valueOf((char) cInt)))
                .map(index -> (index + wheel1Position - 2 * wheel2Position + size) % size)
                .mapToObj(index -> dataBank.get(index))
                .collect(Collectors.joining());
    }
}
