package kr.co.houmuch.core.domain.building.dto;

import kr.co.houmuch.core.domain.code.dto.AreaCode;
import kr.co.houmuch.core.domain.common.dto.Coordinate;
import kr.co.houmuch.core.domain.contract.BuildingType;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Building {
    private String id;
    private String name;
    private Long areaCode;
    private BuildingType type;
    private String addressDetail;
    private Double squareMeter;
    private Integer builtAt;
    private Coordinate coordinate;
}
