package learn.jva;

import learn.utils.PrintUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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
        for (int i = 0; i < 5; i++) {
            PrintUtils.printIntList(sampling.randomSamplingUsingShuffle(ThreadLocalRandom.current()));
        }
    }

    @Test
    @DisplayName("Random Sampling Using Collections.swap method")
    void testRandomSamplingUsingCollectionsSwap() {
        for (int i = 0; i < 5; i++) {
            PrintUtils.printIntList(sampling.randomSamplingUsingSwap());
        }
    }


    @Test
    @DisplayName("Test Random Online Sampling")
    void testRandomOnlineSampling() throws IOException, ClassNotFoundException {
        final var onlineSamplePath = Path.of("src", "test", "resources", "onlineSampling.ser");

        try (final OutputStream os = Files.newOutputStream(onlineSamplePath);
             final ObjectOutputStream oos = new ObjectOutputStream(os)) {
            data.forEach(i-> {
                try {
                    oos.writeObject(Integer.valueOf(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        try(final InputStream is = Files.newInputStream(onlineSamplePath)) {
            PrintUtils.printIntList(sampling.randomOnlineSampling(is));
        }
    }
}