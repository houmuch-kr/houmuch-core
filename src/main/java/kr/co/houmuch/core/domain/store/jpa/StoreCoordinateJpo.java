package kr.co.houmuch.core.domain.store.jpa;

import kr.co.houmuch.core.domain.common.dto.Coordinate;
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
@EntityListeners(AuditingEntityListener.class)
@Table(name = "store_coordinate")
public class StoreCoordinateJpo {
    @Id
    private String id;

    @Embedded
    private CoordinateJpo coordinate;

    @MapsId("id")
    @OneToOne(mappedBy = "coordinate")
    @JoinColumn(name = "id")
    private StoreJpo store;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
