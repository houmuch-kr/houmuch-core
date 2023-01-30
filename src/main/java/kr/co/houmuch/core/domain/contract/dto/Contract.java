package kr.co.houmuch.core.domain.contract.dto;

import kr.co.houmuch.core.domain.building.dto.Building;
import kr.co.houmuch.core.domain.common.dto.CombinedAreaCode;
import kr.co.houmuch.core.domain.common.dto.Coordinate;
import kr.co.houmuch.core.domain.contract.BuildingType;
import kr.co.houmuch.core.domain.contract.ContractType;
import kr.co.houmuch.core.domain.contract.jpa.ContractJpo;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contract {
    private String id;
    private ContractType type;
    private LocalDate contractedAt;
    private String serialNumber;
    private Building building;

    public static Contract entityOf(ContractJpo contractJpo) {
        return builder()
                .id(contractJpo.getId())
                .type(contractJpo.getType())
                .contractedAt(contractJpo.getContractedAt())
                .serialNumber(contractJpo.getSerialNumber())
                .building(Building.builder()
                        .id(contractJpo.getBuilding().getId())
                        .name(contractJpo.getBuilding().getName())
                        .areaCode(contractJpo.getBuilding().getAreaCode().getId())
                        .type(contractJpo.getBuilding().getType())
                        .addressDetail(contractJpo.getBuilding().getAddressDetail())
                        .squareMeter(contractJpo.getBuilding().getSquareMeter())
                        .builtAt(contractJpo.getBuilding().getBuiltAt())
                        .coordinate(Coordinate.of(
                                contractJpo.getBuilding().getCoordinate().getCoordinate().getLatitude(),
                                contractJpo.getBuilding().getCoordinate().getCoordinate().getLongitude()))
                        .build()
                )
                .build();
    }
}
