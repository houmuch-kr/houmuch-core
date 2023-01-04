package kr.co.houmuch.core.client.naver.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.houmuch.core.domain.common.dto.Coordinate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverMapGeocodePayload {
    private String status;
    private Meta meta;
    private List<Address> addresses;

    public List<Coordinate> asCoordinates() {
        return addresses.stream().map(Address::asCoordinate).toList();
    }

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Meta {
        private int totalCount;
        private int page;
        private int count;
    }

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Address {
        @JsonProperty("roadAddress")
        private String road;

        @JsonProperty("jibunAddress")
        private String jibun;

        @JsonProperty("englishAddress")
        private String english;

        private double x;
        private double y;
        private double distance;
        private List<Element> addressElements;

        public Coordinate asCoordinate() {
            return Coordinate.of(y, x);
        }

        @Getter
        @Setter
        @ToString
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Element {
            private List<String> types;
            private String longName;
            private String shortName;
            private String code;
        }
    }
}
