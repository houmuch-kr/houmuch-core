package kr.co.houmuch.core.domain.contract.dto;

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
}
