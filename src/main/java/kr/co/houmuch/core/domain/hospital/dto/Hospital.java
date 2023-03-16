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
    private String code_name;
    private String name;
    private int zip_code;
    private String address;
    private String tel;
    private String url;
    private String built_at;
    private double latitude;
    private double longitude;

    public static Hospital entityOf(HospitalJpo hospitalJpo){
        return builder()
                .id(hospitalJpo.getId())
                .code(hospitalJpo.getCode())
                .code_name(hospitalJpo.getCode_name())
                .name(hospitalJpo.getName())
                .zip_code(hospitalJpo.getZip_code())
                .address(hospitalJpo.getAddress())
                .tel(hospitalJpo.getTel())
                .url(hospitalJpo.getUrl())
                .built_at(hospitalJpo.getBuilt_at())
                .latitude(hospitalJpo.getLatitude())
                .longitude(hospitalJpo.getLongitude())
                .build();
    }
}