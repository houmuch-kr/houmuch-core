package kr.co.houmuch.core.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtils {
    public static DateTimeFormatter formatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

    /**
     * <p>
     * date 의 날짜가 begin 이후이면서 같고, end 이전이면서 같은가 ?
     * <pre>
     *   LocalDate a = LocalDate.of(2023, 1, 25);
     *   LocalDate b = LocalDate.of(2023, 1, 24);
     *   LocalDate begin = LocalDate.of(2023, 1, 25);
     *   LocalDate end = LocalDate.of(2023, 1, 30);
     *   isBetween(a, begin, end) == true
     *   isBetween(b, begin, end) == false
     * </pre>
     * </p>
     */
    public static boolean isBetween(LocalDate date, LocalDate begin, LocalDate end) {
        return isGreaterThanOrEqualsTo(date, begin) && isLessThanOrEqualsTo(date, end);
    }

    /**
     * <p>
     * from 의 날짜가 to 날짜보다 이후이거나 같은가 ?
     * <pre>
     *   LocalDate to = LocalDate.of(2023, 1, 25);
     *   isGreaterThanOrEqualsTo(LocalDate.of(2023, 1, 26), to) == true
     *   isGreaterThanOrEqualsTo(LocalDate.of(2023, 1, 25), to) == true
     *   isGreaterThanOrEqualsTo(LocalDate.of(2023, 1, 24), to) == false
     * </pre>
     * </p>
     */
    public static boolean isGreaterThanOrEqualsTo(LocalDate from, LocalDate to) {
        return from.isEqual(to) || from.isAfter(to);
    }

    /**
     * <p>
     * from 의 날짜가 to 날짜보다 이전이거나 같은가 ?
     * <pre>
     *   LocalDate to = LocalDate.of(2023, 1, 25);
     *   isLessThanOrEqualsTo(LocalDate.of(2023, 1, 26), to) == false
     *   isLessThanOrEqualsTo(LocalDate.of(2023, 1, 25), to) == true
     *   isLessThanOrEqualsTo(LocalDate.of(2023, 1, 24), to) == true
     * </pre>
     * </p>
     */
    public static boolean isLessThanOrEqualsTo(LocalDate from, LocalDate to) {
        return from.isEqual(to) || from.isBefore(to);
    }
}
