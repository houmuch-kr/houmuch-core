package kr.co.houmuch.core.domain.store.jpa;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.common.jpa.CodeJpo;
import kr.co.houmuch.core.domain.common.jpa.IndustryCodeJpo;
import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "store")
public class StoreJpo implements Persistable<String> {
    @Id
    private String id;
    private int serialNumber;
    private String name;
    private String spotName;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private StoreCoordinateJpo coordinate;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private StoreAddressJpo address;

    @ToString.Exclude
    @JoinColumn(name = "area_code")
    @OneToOne(fetch = FetchType.LAZY)
    private AreaCodeJpo areaCode;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private CodeJpo code;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private IndustryCodeJpo industryCode;
    @Override
    public boolean isNew() {
        return true;
    }
}
