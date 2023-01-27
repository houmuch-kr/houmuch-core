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
    private AreaCode area_code;
    private BuildingType type;
    private Double address_detail;
    private Double square_meter;
    private Integer built_at;
}
