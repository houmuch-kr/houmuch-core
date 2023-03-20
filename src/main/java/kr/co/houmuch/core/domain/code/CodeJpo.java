package kr.co.houmuch.core.domain.code;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(name = "category1")
    private String cat1;
    @Column(name = "category2")
    private String cat2;
    @Column(name = "category3")
    private String cat3;

    private String value;
}
