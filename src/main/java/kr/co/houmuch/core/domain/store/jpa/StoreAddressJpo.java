package kr.co.houmuch.core.domain.store.jpa;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store_address")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class StoreAddressJpo {
    @Id
    private String id;
    private String buildingName;

    @Column(name="jibun_address")
    private String jibunAddr;

    @Column(name="road_address")
    private String roadAddr;

    private String updatedAt;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private StoreAddressDetailJpo detail;


}