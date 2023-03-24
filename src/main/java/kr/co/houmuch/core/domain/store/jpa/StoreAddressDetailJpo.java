package kr.co.houmuch.core.domain.store.jpa;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "store_address_detail")
public class StoreAddressDetailJpo {
    @Id
    private String id;

    @MapsId("id")
    @ToString.Exclude
    @OneToOne(mappedBy = "detail")
    @JoinColumn(name = "id")
    private StoreAddressJpo storeAddress;

    private int zipCodeOld;
    private int zipCode;
    private String dong;
    private int floor;
    private int ho;
    private double bunjiMain;
    private double bunjiSub;
}
