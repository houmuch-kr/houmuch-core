package kr.co.houmuch.core.domain.contract;

import kr.co.houmuch.core.domain.JsonSerializable;
import kr.co.houmuch.core.domain.code.AreaCodeJpo;
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
    @Builder.Default
    private Long id = 0L;
    private String type;
    private String serialNumber;
    private String buildingType;
    private LocalDate contractedAt;
    private String name;

    @ToString.Exclude
    @JoinColumn(name = "area_code")
    @OneToOne(fetch = FetchType.LAZY)
    private AreaCodeJpo areaCode;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private ContractDetailJpo detail;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private ContractAdditionalJpo additional;
}
