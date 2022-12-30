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
@Entity
@Table(name = "area_code")
public class AreaCodeJpo {
    @Id
    private Long id;
    private int type;
    private int code;
    private String address;
    private String fullAddress;

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
