package kr.co.houmuch.core.domain.contractSummary.jpa;

import kr.co.houmuch.core.domain.JsonSerializable;
import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import lombok.*;
import org.springframework.context.annotation.Configuration;

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
    private Long id;
    private Double price;
    private int count;

    @ToString.Exclude
    @MapsId("id")
    @OneToOne
    @JoinColumn(name = "area_code")
    private AreaCodeJpo areaCode;

}
