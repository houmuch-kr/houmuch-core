package kr.co.houmuch.core.domain.building.dto;

import kr.co.houmuch.core.domain.code.dto.AreaCode;
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
    private AreaCode areaCode;
    private BuildingType type;
    private Double addressDetail;
    private Double squareMeter;
    private Integer builtAt;
}
