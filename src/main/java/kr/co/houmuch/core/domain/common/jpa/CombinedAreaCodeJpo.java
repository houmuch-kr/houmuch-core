package kr.co.houmuch.core.domain.common.jpa;

import kr.co.houmuch.core.domain.JsonSerializable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class CombinedAreaCodeJpo implements JsonSerializable {
    @Column(name = "sido_code")
    private int sido;

    @Column(name = "sgg_code")
    private int sgg;

    @Column(name = "umd_code")
    private int umd;
}
