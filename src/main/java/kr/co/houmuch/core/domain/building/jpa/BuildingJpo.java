package kr.co.houmuch.core.domain.building.jpa;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.contract.BuildingType;
import lombok.*;

import javax.persistence.*;
import java.time.Year;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "building")
@Builder
public class BuildingJpo {
    @Id
    private String id;
    private String name;
    private String addressDetail;
    private Double squareMeter;
    private Year builtAt;

    @Enumerated(EnumType.STRING)
    private BuildingType type;

    @ToString.Exclude
    @JoinColumn(name = "area_code")
    @OneToOne(fetch = FetchType.LAZY)
    private AreaCodeJpo areaCode;
}
