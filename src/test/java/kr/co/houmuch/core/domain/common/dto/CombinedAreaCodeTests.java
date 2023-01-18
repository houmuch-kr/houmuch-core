package kr.co.houmuch.core.domain.common.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CombinedAreaCode")
public class CombinedAreaCodeTests {
    @ParameterizedTest
    @DisplayName("getFullCode()")
    @CsvSource({"41,4100000000"})
    void getFullCode(Integer sido, Long code) {
        CombinedAreaCode combinedAreaCode = CombinedAreaCode.of(sido);
        assertEquals(combinedAreaCode.getFullCode(), code);
    }

    @ParameterizedTest
    @DisplayName("getFullCode()")
    @CsvSource({"41,650,4165000000"})
    void getFullCode(Integer sido, Integer sgg, Long code) {
        CombinedAreaCode combinedAreaCode = CombinedAreaCode.of(sido, sgg);
        assertEquals(combinedAreaCode.getFullCode(), code);
    }

    @ParameterizedTest
    @DisplayName("getFullCode()")
    @CsvSource({"41,650,10100,4165010100"})
    void getFullCode(Integer sido, Integer sgg, Integer umd, Long code) {
        CombinedAreaCode combinedAreaCode = CombinedAreaCode.of(sido, sgg, umd);
        assertEquals(combinedAreaCode.getFullCode(), code);
    }
}
