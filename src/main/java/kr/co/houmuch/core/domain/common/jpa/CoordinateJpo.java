package kr.co.houmuch.core.domain.common.jpa;

import kr.co.houmuch.core.domain.JsonSerializable;
import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CoordinateJpo implements JsonSerializable {
    private double latitude;
    private double longitude;
}
