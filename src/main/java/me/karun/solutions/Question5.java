package me.karun.solutions;

import me.karun.models.DecryptionTuple;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// http://minisculuschallenge.com/finish/50763edaa9d9bd2a9516280e9044d885.html
public class Question5 {
    public static List<DecryptionTuple> getAllSolutions(final String code) {
        return IntStream.range(0, 10)
                .mapToObj(i -> IntStream.range(0, 10)
                                .mapToObj(j -> new DecryptionTuple(i, j, new Question4(i, j).solve(code)))
                                .filter(DecryptionTuple::isValidSolution)
                                .collect(Collectors.toList())
                ).flatMap(list -> list.stream())
                .collect(Collectors.toList());
    }
}

