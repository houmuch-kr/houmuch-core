package kr.co.houmuch.core.domain.code;

import kr.co.houmuch.core.domain.area.jpa.AreaCoordinateJpo;
import kr.co.houmuch.core.domain.building.jpa.BuildingJpo;
import kr.co.houmuch.core.domain.common.jpa.CombinedAreaCodeJpo;
import kr.co.houmuch.core.domain.contractSummary.jpa.ContractSummaryJpo;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "area_code")
public class AreaCodeJpo {
    @Id
    private Long id;
    private int type;
    private String address;
    private String shortAddress;
    private String fullAddress;

    @Embedded
    private CombinedAreaCodeJpo code;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    private AreaCoordinateJpo coordinate;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "areaCode")
    private List<BuildingJpo> buildingJpo;

//    @ToString.Exclude
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "id")
//    private ContractSummaryJpo contractSummaryJpo;

    /**
     * 지정된 자리수에 해당하는 지역 코드 반환
     * @param from 시작 자리수
     * @param to 끝 자리수
     * @return id[from] ~ id[to]
     */
    public long getIdBy(int from, int to) {
        return Long.parseLong(String.valueOf(id).substring(from, to));
    }

    /**
     * 하위 지역이 상위 지역에 포함이 되는가 ?
     * ex) 서울특별시 종로구는 서울특별시에 포함이 된다
     * <p>
     *     <pre>
     *         CombinedAreaCodeJpo a = new CombinedAreaCode(11, 0, 0);
     *         ConbinedAreaCodeJpo b = new CombinedAreaCode(11, 110, 0);
     *         AreaCodeJpo aa = AreaCodeJpo.builder().code(a).build();
     *         AreaCodeJpo bb = AreaCodeJpo.builder().code(b).build();
     *         aa.isHierarchy(bb) == true
     *         bb.isHierarchy(aa) == false
     *     </pre>
     * </p>
     */
    public boolean isHierarchy(AreaCodeJpo areaCodeJpo) {
        return switch (this.getType()) {
            case 0 -> this.getCode().getSido() == areaCodeJpo.getCode().getSido();
            case 1 -> this.getCode().getSido() == areaCodeJpo.getCode().getSido()
                    && this.getCode().getSgg() == areaCodeJpo.getCode().getSgg();
            case 2 -> this.getCode().getSido() == areaCodeJpo.getCode().getSido()
                    && this.getCode().getSgg() == areaCodeJpo.getCode().getSgg()
                    && this.getCode().getUmd() == areaCodeJpo.getCode().getUmd();
            case 3 -> this.getCode().getSido() == areaCodeJpo.getCode().getSido()
                    && this.getCode().getSgg() == areaCodeJpo.getCode().getSgg()
                    && this.getCode().getUmd() == areaCodeJpo.getCode().getUmd()
                    && this.getId().equals(areaCodeJpo.getId());
            default -> throw new RuntimeException();
        };
    }
}
