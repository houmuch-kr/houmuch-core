package kr.co.houmuch.core.util;

public final class RandomGenerator {
    public static long generatorLong(int digit) {
        long start = (long) Math.pow(10, digit - 1);
        long end = (long) Math.pow(10, digit) - 1;
        return start + ((long) (Math.random() * (end - start)));
    }
}
