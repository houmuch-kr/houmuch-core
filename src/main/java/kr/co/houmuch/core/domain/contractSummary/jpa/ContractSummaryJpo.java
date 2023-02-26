package kr.co.houmuch.core.domain.contractSummary.jpa;

import kr.co.houmuch.core.domain.JsonSerializable;
import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contract_summary")
@Builder
public class ContractSummaryJpo implements JsonSerializable {
    private Long areaCode;
    private Double price;
    private int count;

//    @ToString.Exclude
//    @Id
//    @MapsId("id")
//    @OneToOne(mappedBy = "contractSummaryJpo")
//    @JoinColumn(name = "id")
//    private AreaCodeJpo areaCode;

}
