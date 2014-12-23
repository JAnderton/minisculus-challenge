package me.karun.solutions;

import java.util.stream.Collectors;

// http://minisculuschallenge.com/questions/4baecf8ca3f98dc13eeecbac263cd3ed.html
public class Question4 implements Question {
    private final int wheel1Position;
    private final int wheel2Position;
    private int wheel3Position = 0;

    public Question4() {
        this(7, 2);
    }

    public Question4(int wheel1Position, int wheel2Position) {
        this.wheel1Position = wheel1Position;
        this.wheel2Position = wheel2Position;
    }

    @Override
    public String solve(final String question) {
        return question.chars()
                .map(cInt -> dataBank.indexOf(String.valueOf((char) cInt)))
                .map(index -> {
                    final int offset = (wheel1Position - 2 * wheel2Position + 2 * wheel3Position + size) % size;
                    return wheel3Position = (index - offset + size) % size;
                })
                .mapToObj(updatedIndex -> dataBank.get(updatedIndex))
                .collect(Collectors.joining());
    }
}
