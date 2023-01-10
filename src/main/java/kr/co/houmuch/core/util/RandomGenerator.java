package kr.co.houmuch.core.util;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RandomGenerator {
    private static final String CHARS = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static long generatorLong(int digit) {
        long start = (long) Math.pow(10, digit - 1);
        long end = (long) Math.pow(10, digit) - 1;
        return start + ((long) (Math.random() * (end - start)));
    }

    public static String generator(int digit) {
        return IntStream.range(0, digit)
                .map(number -> (int) (Math.random() * CHARS.length()))
                .mapToObj(CHARS::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
