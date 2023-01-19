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
@Table(name = "contract_detail")
@Builder
public class ContractDetailJpo implements JsonSerializable {
    @Id
    private String id;

    @MapsId("id")
    @ToString.Exclude
    @OneToOne(mappedBy = "detail")
    @JoinColumn(name = "id")
    private ContractJpo contract;
    private Integer price;
    private Integer monthlyPrice;
    private Integer floor;
}
