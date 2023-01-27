package kr.co.houmuch.core.domain.code.dto;

import kr.co.houmuch.core.domain.common.dto.CombinedAreaCode;
import kr.co.houmuch.core.domain.common.dto.Coordinate;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreaCode {
    private Long id;
    private int type;
    private String address;
    private String shortAddress;
    private String fullAddress;
    private CombinedAreaCode code;
    private Coordinate coordinate;
}
