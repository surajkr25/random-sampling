package learn.jva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSampling {

    private final List<Integer> data;
    private final int sampleSize;

    public RandomSampling(List<Integer> data, int sampleSize) {
        this.data = new ArrayList<>(data); // Create a mutable copy
        this.sampleSize = sampleSize;
    }

    public List<Integer> randomSamplingUsingShuffle(Random randomSeed) {
//        List<Integer> workingCopy = new ArrayList<>(data); // Work with a copy to preserve original data

        if (randomSeed == null) Collections.shuffle(data);
        else Collections.shuffle(data, randomSeed);

        return data.subList(0, sampleSize);
    }

    public List<Integer> randomSamplingUsingSwap() {
        for (int i = 0; i < sampleSize; i++) {
            Collections.swap(data, i, ThreadLocalRandom.current().nextInt(data.size() - i));
        }

        return data.subList(0, sampleSize);
    }
}
