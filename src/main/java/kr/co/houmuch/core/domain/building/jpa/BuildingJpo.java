package kr.co.houmuch.core.domain.building.jpa;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.contract.BuildingType;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "building", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "name", "type", "area_code" })
})
@Builder
public class BuildingJpo {
    @Id
    private String id;
    private String name;
    private String addressDetail;
    private Double squareMeter;
    private Integer builtAt;

    @Enumerated(EnumType.STRING)
    private BuildingType type;

    @ToString.Exclude
    @JoinColumn(name = "area_code")
    @OneToOne(fetch = FetchType.LAZY)
    private AreaCodeJpo areaCode;

    @NotFound(action = NotFoundAction.IGNORE)
    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private BuildingCoordinateJpo coordinate;
}
