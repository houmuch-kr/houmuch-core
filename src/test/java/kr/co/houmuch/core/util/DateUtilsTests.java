package kr.co.houmuch.core.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("DateUtils")
public class DateUtilsTests {
    @Test
    @DisplayName("isBetween(date, begin, end)")
    public void isBetweenTest() {
        LocalDate begin = LocalDate.of(2023, 1, 25);
        LocalDate end = LocalDate.of(2023, 1, 30);
        assertTrue(DateUtils.isBetween(LocalDate.of(2023, 1, 25), begin, end));
        assertFalse(DateUtils.isBetween(LocalDate.of(2023, 1, 24), begin, end));
    }

    @Test
    @DisplayName("isGreaterThanOrEqualsTo(from, to)")
    public void isGreaterThanOrEqualsToTest() {
        LocalDate to = LocalDate.of(2023, 1, 25);
        assertTrue(DateUtils.isGreaterThanOrEqualsTo(LocalDate.of(2023, 1, 26), to));
        assertTrue(DateUtils.isGreaterThanOrEqualsTo(LocalDate.of(2023, 1, 25), to));
        assertFalse(DateUtils.isGreaterThanOrEqualsTo(LocalDate.of(2023, 1, 24), to));
    }

    @Test
    @DisplayName("isLessThanOrEqualsTo(from, to)")
    public void isLessThanOrEqualsToTest() {
        LocalDate to = LocalDate.of(2023, 1, 25);
        assertFalse(DateUtils.isLessThanOrEqualsTo(LocalDate.of(2023, 1, 26), to));
        assertTrue(DateUtils.isLessThanOrEqualsTo(LocalDate.of(2023, 1, 25), to));
        assertTrue(DateUtils.isLessThanOrEqualsTo(LocalDate.of(2023, 1, 24), to));
    }
}
