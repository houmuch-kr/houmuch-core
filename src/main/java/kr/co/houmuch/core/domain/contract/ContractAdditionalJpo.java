package kr.co.houmuch.core.domain.contract;

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
public class ContractAdditionalJpo {
    @Id
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
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
