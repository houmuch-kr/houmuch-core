package kr.co.houmuch.core.domain.area.jpa;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.common.jpa.CoordinateJpo;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "area_coordinate")
@EntityListeners(AuditingEntityListener.class)
public class AreaCoordinateJpo {
    @Id
    @Column(name = "area_code")
    private Long id;

    @Embedded
    private CoordinateJpo coordinate;

    @ToString.Exclude
    @MapsId("id")
    @OneToOne(mappedBy = "coordinate")
    @JoinColumn(name = "id")
    private AreaCodeJpo areaCode;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
