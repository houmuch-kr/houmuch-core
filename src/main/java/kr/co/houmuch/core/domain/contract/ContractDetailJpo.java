package kr.co.houmuch.core.domain.contract;

import kr.co.houmuch.core.domain.JsonSerializable;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract_detail")
@Builder
public class ContractDetailJpo implements JsonSerializable {
    @Id
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private ContractJpo contract;
    private Integer price;
    private Integer monthlyPrice;
    private Integer floor;
    private String addressDetail;
    private Double squareMeter;
    private Integer builtAt;
}
