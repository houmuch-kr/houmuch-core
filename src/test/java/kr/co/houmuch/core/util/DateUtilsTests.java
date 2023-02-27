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

    @Test
    @DisplayName("isFromDay(date, day)")
    public void isFromDay() {
        final int day = 7;
        assertTrue(DateUtils.isFromDay(LocalDate.now().minusDays(7), day));
        assertFalse(DateUtils.isFromDay(LocalDate.now().minusDays(8), day));
    }

    @Test
    @DisplayName("isFromMonth(date, month)")
    public void isFromMonth() {
        final int month = 1;
        assertTrue(DateUtils.isFromMonth(LocalDate.now().minusMonths(1).plusDays(1), month));
        assertFalse(DateUtils.isFromMonth(LocalDate.now().minusMonths(2), month));
    }

    @Test
    @DisplayName("isFromYear(date, year)")
    public void isFromYear() {
        final int year = 1;
        assertTrue(DateUtils.isFromYear(LocalDate.now().minusYears(1).plusDays(1), year));
        assertFalse(DateUtils.isFromYear(LocalDate.now().minusYears(2), year));
    }
}
