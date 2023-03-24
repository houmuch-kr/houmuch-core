package kr.co.houmuch.core.domain.common.jpa;

import kr.co.houmuch.core.domain.store.jpa.StoreJpo;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "code")
public class CodeJpo {
    @Id
    private String id;
    private String value;

    @MapsId("id")
    @OneToOne(mappedBy = "code")
    @JoinColumn(name = "id")
    private StoreJpo store;

    @Column(name = "category1")
    private String cat1;
    @Column(name = "category2")
    private String cat2;
    @Column(name = "category3")
    private String cat3;

}
