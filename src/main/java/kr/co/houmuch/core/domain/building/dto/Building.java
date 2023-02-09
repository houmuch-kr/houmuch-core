package kr.co.houmuch.core.domain.building.dto;

import kr.co.houmuch.core.domain.building.jpa.BuildingJpo;
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
    private AreaCode areaCode;
    private BuildingType type;
    private String addressDetail;
    private Double squareMeter;
    private Integer builtAt;
    private Coordinate coordinate;

    public static Building entityOf(BuildingJpo buildingJpo) {
        return Building.builder()
                .id(buildingJpo.getId())
                .name(buildingJpo.getName())
                .areaCode(AreaCode.entityOf(buildingJpo.getAreaCode()))
                .type(buildingJpo.getType())
                .addressDetail(buildingJpo.getAddressDetail())
                .squareMeter(buildingJpo.getSquareMeter())
                .builtAt(buildingJpo.getBuiltAt())
                .coordinate(Coordinate.entityOf(buildingJpo.getCoordinate().getCoordinate()))
                .build();
    }
}
