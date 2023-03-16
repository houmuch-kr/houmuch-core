package kr.co.houmuch.core.domain.hospital.dto;

import kr.co.houmuch.core.domain.JsonSerializable;
import kr.co.houmuch.core.domain.hospital.jpa.HospitalJpo;
import lombok.*;

import javax.persistence.Id;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hospital {
    private String id;
    private String code;
    private String codeName;
    private String name;
    private int zipCode;
    private String address;
    private String tel;
    private String url;
    private String builtAt;
    private double latitude;
    private double longitude;

    public static Hospital entityOf(HospitalJpo hospitalJpo){
        return builder()
                .id(hospitalJpo.getId())
                .code(hospitalJpo.getCode())
                .codeName(hospitalJpo.getCodeName())
                .name(hospitalJpo.getName())
                .zipCode(hospitalJpo.getZipCode())
                .address(hospitalJpo.getAddress())
                .tel(hospitalJpo.getTel())
                .url(hospitalJpo.getUrl())
                .builtAt(hospitalJpo.getBuiltAt())
                .latitude(hospitalJpo.getLatitude())
                .longitude(hospitalJpo.getLongitude())
                .build();
    }
}