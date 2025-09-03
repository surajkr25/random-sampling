package learn.jva;

import learn.utils.PrintUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RandomSamplingTest {

    private final List<Integer> data = Stream.iterate(1, n -> n + 1)
            .limit(10L)
            .collect(Collectors.toList());

    private final int sampleSize = 4;

    private final RandomSampling sampling = new RandomSampling(data, sampleSize);


    @BeforeEach
    void setUp() {
            System.out.println("Original List");
            PrintUtils.printIntList(data);
            System.out.printf("---------Sample of size %d: %n", sampleSize);
    }

    @Test
    @DisplayName("Random Sampling Using Collections.Shuffle method")
    void testRandomSamplingUsingCollectionsShuffle() {
        for(int i = 0 ; i < 5 ; i++) {
            PrintUtils.printIntList(sampling.randomSamplingUsingShuffle(null));
        }
    }
}