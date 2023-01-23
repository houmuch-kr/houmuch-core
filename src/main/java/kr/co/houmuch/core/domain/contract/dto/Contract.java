package kr.co.houmuch.core.domain.contract.dto;

import kr.co.houmuch.core.domain.common.dto.CombinedAreaCode;
import kr.co.houmuch.core.domain.contract.BuildingType;
import kr.co.houmuch.core.domain.contract.ContractType;
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
    private BuildingType buildingType;
    private Long areaCode;
    private LocalDate contractedAt;
    private String serialNumber;
    private String name;

    public static Contract of(String id, ContractType type, BuildingType buildingType, Long areaCode, LocalDate contractedAt, String serialNumber, String name) {
        return new Contract(id, type, buildingType, areaCode, contractedAt, serialNumber, name);
    }

}
