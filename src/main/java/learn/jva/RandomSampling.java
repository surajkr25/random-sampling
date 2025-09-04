package learn.jva;

import learn.utils.PrintUtils;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

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

    public List<Integer> randomOnlineSampling(InputStream is) throws IOException, ClassNotFoundException {
        final List<Integer> runnngSample = new ArrayList<>(sampleSize);

        final var ois = new ObjectInputStream(is);

        for(int i = 0; i < sampleSize; i++) {
            final Integer j = (Integer) ois.readObject();
            runnngSample.add(j);
        }

        int numbersSeenSoFar = sampleSize;

        while (true) {
            try{
                final Integer k = (Integer) ois.readObject();
                ++numbersSeenSoFar;
                final var id2Replace = ThreadLocalRandom.current().nextInt(numbersSeenSoFar);

                if(id2Replace < sampleSize) {
                    runnngSample.set(id2Replace, k);
                }

                TimeUnit.MILLISECONDS.sleep(500L);

                PrintUtils.printIntList(runnngSample);
            } catch (final EOFException eof) {
                break;
            } catch (final InterruptedException i) {
                i.printStackTrace();
            }
        }

        ois.close();
        return runnngSample;
    }
}
