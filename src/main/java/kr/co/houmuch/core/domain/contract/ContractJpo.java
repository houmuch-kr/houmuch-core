package kr.co.houmuch.core.domain.contract;

import kr.co.houmuch.core.domain.JsonSerializable;
import kr.co.houmuch.core.domain.building.jpa.BuildingJpo;
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
    @OneToOne(fetch = FetchType.LAZY)
    private BuildingJpo building;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private ContractDetailJpo detail;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private ContractAdditionalJpo additional;
}
