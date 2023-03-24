package kr.co.houmuch.core.client.store.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.common.dto.Coordinate;
import kr.co.houmuch.core.domain.common.jpa.CodeJpo;
import kr.co.houmuch.core.domain.common.jpa.IndustryCodeJpo;
import kr.co.houmuch.core.domain.common.jpa.CoordinateJpo;
import kr.co.houmuch.core.domain.store.jpa.StoreAddressDetailJpo;
import kr.co.houmuch.core.domain.store.jpa.StoreAddressJpo;
import kr.co.houmuch.core.domain.store.jpa.StoreCoordinateJpo;
import kr.co.houmuch.core.domain.store.jpa.StoreJpo;
import kr.co.houmuch.core.util.RandomGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
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
            private String id;
            @JsonProperty("ksicNm")
            private String codeName;

            public StoreJpo asJpo() {
                String randomId = RandomGenerator.generator(10);
                StoreAddressDetailJpo storeAddressDetailJpo = StoreAddressDetailJpo.builder()
                        .id(randomId)
                        .zipCodeOld(zipCodeOld)
                        .zipCode(zipCode)
                        .dong(dong)
                        .floor(floor)
                        .ho(ho)
                        .bunjiMain(bunjiMain)
                        .bunjiSub(bunjiSub)
                        .build();
                StoreAddressJpo storeAddressJpo = StoreAddressJpo.builder()
                        .id(randomId)
                        .buildingName(buildingName)
                        .detail(storeAddressDetailJpo)
                        .jibunAddr(jibunAddr)
                        .roadAddr(roadAddr)
                        .build();
                StoreCoordinateJpo storeCoordinateJpo = StoreCoordinateJpo.builder()
                        .id(randomId)
                        .coordinate(Coordinate.of(latitude,longitude).asJpo())
                        .build();
                CodeJpo codeJpo = CodeJpo.builder()
                        .id(randomId)
                        .value(value)
                        .cat1(cat1)
                        .cat2(cat2)
                        .cat3(cat3)
                        .build();
                IndustryCodeJpo industryCodeJpo = IndustryCodeJpo.builder()
                        .storeId(randomId)
                        .store(StoreJpo.builder().id(randomId).build())
                        .id(id)
                        .name(codeName)
                        .build();
                AreaCodeJpo areaCodeJpo = AreaCodeJpo.builder()
                        .id(areaCode)
                        .build();


                return StoreJpo.builder()
                        .id(randomId)
                        .serialNumber(serialNumber)
                        .name(name)
                        .spotName(spotName)
                        .coordinate(storeCoordinateJpo)
                        .address(storeAddressJpo)
                        .areaCode(areaCodeJpo)
                        .code(codeJpo)
                        .industryCode(industryCodeJpo)
                        .build();
            }
        }
   }
}
