package kr.co.houmuch.core.domain.code;

import lombok.*;

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
@Table(name = "industry_code")
public class IndustryCodeJpo {
    @Id
    private String id;
    private String field1;
    private String field2;
}
