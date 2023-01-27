package kr.co.houmuch.core.domain.building.jpa;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.contract.BuildingType;
import lombok.*;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private AreaCodeJpo areaCode;

    @ToString.Exclude
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private BuildingCoordinateJpo coordinate;

    /**
     * 건물의 전체 주소 반환
     * 광역시/도, 시/군/구, 읍/면/동, 상세주소를 포함함
     * @return 예시) 서울시 종로구 익선동 461
     */
    public String getFullAddress() {
        return String.format("%s %s", areaCode.getFullAddress(), addressDetail);
    }
}
