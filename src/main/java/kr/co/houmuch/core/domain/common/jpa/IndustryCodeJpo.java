package kr.co.houmuch.core.domain.common.jpa;

import kr.co.houmuch.core.domain.store.jpa.StoreJpo;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "industry_code")
public class IndustryCodeJpo {
    @Id
    @Column(name = "store_id")
    private String storeId;

    @MapsId("storeId")
    @OneToOne(mappedBy = "industryCode")
    @JoinColumn(name = "store_id")
    private StoreJpo store;

    private String id;
    private String name;
}
