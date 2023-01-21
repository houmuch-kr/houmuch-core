package kr.co.houmuch.core.domain.building.jpa;

import kr.co.houmuch.core.domain.common.jpa.CombinedAreaCodeJpo;
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
@Entity
@Table(name = "building_coordinate")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class BuildingCoordinateJpo {
    @Id
    @Column(name = "building_id")
    private String id;

    @Embedded
    private CombinedAreaCodeJpo code;

    @MapsId("id")
    @ToString.Exclude
    @OneToOne(mappedBy = "coordinate")
    @JoinColumn(name = "id")
    private BuildingJpo building;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
