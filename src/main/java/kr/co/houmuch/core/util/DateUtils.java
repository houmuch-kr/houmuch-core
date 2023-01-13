package kr.co.houmuch.core.util;

import java.time.format.DateTimeFormatter;

public final class DateUtils {
    public static DateTimeFormatter formatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }
}
