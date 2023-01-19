package kr.co.houmuch.core.domain.contract.jpa;

import kr.co.houmuch.core.domain.JsonSerializable;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract_additional")
@Builder
public class ContractAdditionalJpo implements JsonSerializable {
    @Id
    private String id;

    @MapsId("id")
    @ToString.Exclude
    @OneToOne(mappedBy = "additional")
    @JoinColumn(name = "id")
    private ContractJpo contract;
    private String contractType;
    private String term;
    private String useRefreshClaim;
    private String previousPrice;
    private String previousMonthlyPrice;
    private String releaseAt;
    private String release;
}
