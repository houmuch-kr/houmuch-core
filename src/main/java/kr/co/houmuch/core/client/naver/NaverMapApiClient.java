package kr.co.houmuch.core.client.naver;

import kr.co.houmuch.core.client.BaseApiClient;
import kr.co.houmuch.core.client.naver.payload.NaverMapGeocodePayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class NaverMapApiClient extends BaseApiClient {
    private final WebClient naverMapWebClient;
    private static final String BASE_URL_GEOCODE = "/map-geocode/v2/geocode";

    /**
     * 네이버 Geocoder 요청 (주소 -> 좌표 변환)
     * @param address 전체주소 (ex. 서울특별시 종로구 익선동)
     */
    public Mono<List<NaverMapGeocodePayload.Address>> fetchGeocode(String address) {
        return naverMapWebClient.get()
                .uri(uriBuilder -> uriBuilder.path(BASE_URL_GEOCODE).queryParam("query", address).build())
                .retrieve()
                .onStatus(HttpStatus::isError, ClientResponse::createException)
                .toEntity(NaverMapGeocodePayload.class)
                .doOnNext(this::validateStatusOk)
                .mapNotNull(ResponseEntity::getBody)
                .map(NaverMapGeocodePayload::getAddresses);
    }
}
