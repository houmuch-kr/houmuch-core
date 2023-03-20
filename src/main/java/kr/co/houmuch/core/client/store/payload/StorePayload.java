package kr.co.houmuch.core.client.store.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.code.CodeJpo;
import kr.co.houmuch.core.domain.code.IndustryCodeJpo;
import kr.co.houmuch.core.domain.common.dto.Coordinate;
import kr.co.houmuch.core.domain.common.jpa.CoordinateJpo;
import kr.co.houmuch.core.domain.store.jpa.StoreAddressDetailJpo;
import kr.co.houmuch.core.domain.store.jpa.StoreAddressJpo;
import kr.co.houmuch.core.domain.store.jpa.StoreCoordinateJpo;
import kr.co.houmuch.core.domain.store.jpa.StoreJpo;
import kr.co.houmuch.core.util.RandomGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StorePayload {
    private Body body;
    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Body{
        private List<Store> items;
        @Getter
        @Setter
        @ToString
        @JsonIgnoreProperties(ignoreUnknown = true)
        //@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Store {
            //private String id;
            // STORE
            @JsonProperty("bizesId")
            private int serialNumber;
            @JsonProperty("bizesNm")
            private String name;
            @JsonProperty("brchNm")
            private String spotName;
            @JsonProperty("ldongCd")
            private Long areaCode;// 왜 long이 아닐까
            //STORE_COORDINATE
            @JsonProperty("lat")
            private double latitude;
            @JsonProperty("lon")
            private double longitude;
            //STORE_ADDRESS
            @JsonProperty("bldNm")
            private String buildingName;
            @JsonProperty("lnoAdr")
            private String jibunAddr;
            @JsonProperty("rdnmAdr")
            private String roadAddr;
            //STORE_ADDRESS_DETAIL
            @JsonProperty("oldZipcd")
            private int zipCodeOld;
            @JsonProperty("newZipcd")
            private int zipCode;
            @JsonProperty("dongNo")
            private String dong;
            @JsonProperty("flrNo")
            private int floor;
            @JsonProperty("hoNo")
            private int ho;
            @JsonProperty("bldMnno")
            private double bunjiMain;
            @JsonProperty("bldSlno")
            private double bunjiSub;
            //CODE
            @JsonProperty("indsLclsCd")
            private String cat1;
            @JsonProperty("indsMclsCd")
            private String cat2;
            @JsonProperty("indsSclsCd")
            private String cat3;
            @JsonProperty("indsSclsNm")
            private String value;
            //INDUSTRY_CODE
            @JsonProperty("ksicCd")
            private String field1;
            @JsonProperty("ksicNm")
            private String field2;

            public StoreJpo asJpo(Store store) {
                String randomId = RandomGenerator.generator(10);
                return StoreJpo.builder()
                        .id(randomId)
                        .serialNumber(serialNumber)
                        .name(name)
                        .spotName(spotName)
                        .areaCode(AreaCodeJpo.builder().id(areaCode).build())
                        .coordinate(StoreCoordinateJpo.builder()
                                .coordinate(new CoordinateJpo(latitude,longitude))
                                .build())
                        .address(StoreAddressJpo.builder()
                                // id 넣어야할까
                                .buildingName(buildingName)
                                .jibunAddr(jibunAddr)
                                .roadAddr(roadAddr)
                                .detail(StoreAddressDetailJpo.builder()
                                        //id 넣어야할까
                                        .zipCodeOld(zipCodeOld)
                                        .zipCode(zipCode)
                                        .dong(dong)
                                        .floor(floor)
                                        .ho(ho)
                                        .bunjiMain(bunjiMain)
                                        .bunjiSub(bunjiSub)
                                        .build())
                                .build())
                        .code(CodeJpo.builder()
                                //id 넣어야할까
                                .cat1(cat1)
                                .cat2(cat2)
                                .cat3(cat3)
                                .value(value)
                                .build())
                        .industryCode(IndustryCodeJpo.builder()
                                //id넣어야할까
                                .field1(field1)
                                .field2(field2)
                                .build())
                        .build();
            }
        }
   }
            // 테이블 Insert를 위한 Payload DTO > JPO

}
