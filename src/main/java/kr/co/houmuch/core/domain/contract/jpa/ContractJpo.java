package kr.co.houmuch.core.domain.contract.jpa;

import kr.co.houmuch.core.domain.JsonSerializable;
import kr.co.houmuch.core.domain.building.jpa.BuildingJpo;
import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.contract.ContractType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract")
@Builder
public class ContractJpo implements JsonSerializable {
    @Id
    private String id;
    private String serialNumber;
    private LocalDate contractedAt;

    @Enumerated(EnumType.STRING)
    private ContractType type;

    @ToString.Exclude
    @JoinColumn(name = "building_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private BuildingJpo building;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private ContractDetailJpo detail;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private ContractAdditionalJpo additional;

    /**
     * 지역 코드 비교
     */
    public boolean equalsAreaCode(AreaCodeJpo areaCodeJpo) {
        return areaCodeJpo.getId().equals(building.getAreaCode().getId());
    }
}
