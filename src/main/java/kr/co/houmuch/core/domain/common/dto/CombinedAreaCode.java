package kr.co.houmuch.core.domain.common.dto;

import lombok.*;

import static java.util.Objects.nonNull;

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

    public Long getFullCode() {
        long code = 0;
        if (nonNull(sido) && sido != 0) {
            code = sido * 100000000;
        }
        if (nonNull(sgg) && sgg != 0) {
            code += sgg * 100000;
        }
        if (nonNull(umd) && umd != 0) {
            code += umd;
        }
        if (code < 1100000000) {
            throw new IllegalArgumentException("법정동 표준코드는 1100000000 미만일 수 없습니다.");
        }
        return code;
    }

    public static CombinedAreaCode of(Integer sido) {
        return of(sido, null, null);
    }

    public static CombinedAreaCode of(Integer sido, Integer sgg) {
        return of(sido, sgg, null);
    }

    public static CombinedAreaCode of(Integer sido, Integer sgg, Integer umd) {
        return new CombinedAreaCode(sido, sgg, umd);
    }
}
