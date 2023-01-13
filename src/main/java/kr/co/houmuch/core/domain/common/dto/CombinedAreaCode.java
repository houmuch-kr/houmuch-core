package kr.co.houmuch.core.domain.common.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CombinedAreaCode {
    private Integer sido;
    private Integer sgg;
    private Integer umd;

    private static CombinedAreaCode of(Integer sido) {
        return of(sido, null, null);
    }

    private static CombinedAreaCode of(Integer sido, Integer sgg) {
        return of(sido, sgg, null);
    }

    public static CombinedAreaCode of(Integer sido, Integer sgg, Integer umd) {
        return new CombinedAreaCode(sido, sgg, umd);
    }
}
