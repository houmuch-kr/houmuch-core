package kr.co.houmuch.core.domain.hospital.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Code {
    private String value;
    private String name;
}
