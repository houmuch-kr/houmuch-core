package kr.co.houmuch.core.domain.code;

import kr.co.houmuch.core.domain.area.jpa.AreaCoordinateJpo;
import kr.co.houmuch.core.domain.common.jpa.CombinedAreaCodeJpo;
import lombok.*;

import javax.persistence.*;

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

    /**
     * 지정된 자리수에 해당하는 지역 코드 반환
     * @param from 시작 자리수
     * @param to 끝 자리수
     * @return id[from] ~ id[to]
     */
    public long getIdBy(int from, int to) {
        return Long.parseLong(String.valueOf(id).substring(from, to));
    }
}
