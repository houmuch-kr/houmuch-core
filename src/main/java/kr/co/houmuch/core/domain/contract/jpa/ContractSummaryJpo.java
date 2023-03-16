package kr.co.houmuch.core.domain.contract.jpa;

import kr.co.houmuch.core.domain.JsonSerializable;
import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract_summary")
@Builder
public class ContractSummaryJpo implements JsonSerializable {
    @Id
    @Column(name = "area_code")
    private long id;
    private Double price;
    private int count;

    @ToString.Exclude
    @MapsId
    @OneToOne
    @JoinColumn(name = "area_code")
    private AreaCodeJpo areaCode;
}
