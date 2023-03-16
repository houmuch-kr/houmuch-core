package kr.co.houmuch.core.domain.hospital.dto;

import kr.co.houmuch.core.domain.hospital.jpa.HospitalJpo;
import lombok.*;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hospital {
    private String id;
    private Code code;
    private String name;
    private int zipCode;
    private String address;
    private String tel;
    private String url;
    private String builtAt;
    private Coordinate coordinate;

    public static Hospital entityOf(HospitalJpo hospitalJpo){
        return builder()
                .id(hospitalJpo.getId())
                .code(Code.builder()
                        .name(hospitalJpo.getCodeName())
                        .value(hospitalJpo.getCode())
                        .build())
                .name(hospitalJpo.getName())
                .zipCode(hospitalJpo.getZipCode())
                .address(hospitalJpo.getAddress())
                .tel(hospitalJpo.getTel())
                .url(hospitalJpo.getUrl())
                .builtAt(hospitalJpo.getBuiltAt())
                .coordinate(Coordinate.builder()
                        .latitude(hospitalJpo.getLatitude())
                        .longitude(hospitalJpo.getLongitude())
                        .build())
                .build();
    }
}