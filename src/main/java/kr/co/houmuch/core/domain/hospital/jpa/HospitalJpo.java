package kr.co.houmuch.core.domain.hospital.jpa;

import kr.co.houmuch.core.domain.JsonSerializable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hospital")
public class HospitalJpo implements JsonSerializable {
    @Id
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
}