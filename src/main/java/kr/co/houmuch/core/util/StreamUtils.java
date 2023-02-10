package kr.co.houmuch.core.util;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class StreamUtils {
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        return list.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .toList();
    }

    public static <T> long filterCount(List<T> list, Predicate<T> predicate) {
        return filter(list, predicate).size();
    }
}
