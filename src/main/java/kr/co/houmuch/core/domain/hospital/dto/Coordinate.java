package kr.co.houmuch.core.domain.hospital.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coordinate {
    private double latitude;
    private double longitude;
}
