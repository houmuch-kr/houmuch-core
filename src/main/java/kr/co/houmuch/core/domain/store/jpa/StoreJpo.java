package kr.co.houmuch.core.domain.store.jpa;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.code.CodeJpo;
import kr.co.houmuch.core.domain.code.IndustryCodeJpo;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "store")
public class StoreJpo {
    @Id
    private String id;
    private int serialNumber;
    private String name;
    private String spotName;

    // @ToString.Exclude
    @JoinColumn(name = "area_code")
    @OneToOne(fetch = FetchType.LAZY)
    private AreaCodeJpo areaCode;

    // @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private StoreCoordinateJpo coordinate;

    // @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private StoreAddressJpo address;

    // @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CodeJpo code;

    // @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private IndustryCodeJpo industryCode;

}
