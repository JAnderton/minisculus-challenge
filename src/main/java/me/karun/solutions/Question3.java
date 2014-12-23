package me.karun.solutions;

import java.util.stream.Collectors;

// http://minisculuschallenge.com/questions/36d80eb0c50b49a509b49f2424e8c805.html
public class Question3 implements Question {
    private final int wheel1Position = 4;
    private final int wheel2Position = 7;
    private int wheel3Position = 0;

    @Override
    public String solve(final String question) {
        return question.chars()
                .map(cInt -> dataBank.indexOf(String.valueOf((char) cInt)))
                .map(index -> {
                    final int offset = wheel1Position - 2 * wheel2Position + 2 * wheel3Position;
                    wheel3Position = index;
                    return (index + offset + size) % size;
                })
                .mapToObj(index -> dataBank.get(index))
                .collect(Collectors.joining());
    }
}
