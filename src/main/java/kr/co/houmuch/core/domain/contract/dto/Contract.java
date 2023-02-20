package kr.co.houmuch.core.domain.contract.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.houmuch.core.domain.building.dto.Building;
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
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Contract {
    private String id;
    private ContractType type;
    private LocalDate contractedAt;
    private String serialNumber;
    private Integer floor;
    private int price;
    private Integer monthlyPrice;
    private Building building;

    public static Contract entityOf(ContractJpo contractJpo) {
        return builder()
                .id(contractJpo.getId())
                .type(contractJpo.getType())
                .contractedAt(contractJpo.getContractedAt())
                .serialNumber(contractJpo.getSerialNumber())
                .floor(contractJpo.getDetail().getFloor())
                .price(contractJpo.getDetail().getPrice())
                .monthlyPrice(contractJpo.getDetail().getMonthlyPrice())
                .building(Building.entityOf(contractJpo.getBuilding()))
                .build();
    }
}
