package kr.co.houmuch.core.domain.code.dto;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
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

    public static AreaCode entityOf(AreaCodeJpo areaCodeJpo) {
        return builder()
                .id(areaCodeJpo.getId())
                .type(areaCodeJpo.getType())
                .address(areaCodeJpo.getAddress())
                .shortAddress(areaCodeJpo.getShortAddress())
                .fullAddress(areaCodeJpo.getFullAddress())
                .code(CombinedAreaCode.of(
                                areaCodeJpo.getCode().getSido(),areaCodeJpo.getCode().getSgg(),
                                areaCodeJpo.getCode().getUmd()))
                .coordinate(Coordinate.of(
                                areaCodeJpo.getCoordinate().getCoordinate().getLatitude(),
                                areaCodeJpo.getCoordinate().getCoordinate().getLongitude()))
                .build();
    }
}
