package kr.co.houmuch.core.client.store;

import kr.co.houmuch.core.client.BaseApiClient;
import kr.co.houmuch.core.client.store.payload.StorePayload;
import kr.co.houmuch.core.config.properties.StoreApiProperties;
import kr.co.houmuch.core.domain.store.jpa.StoreJpo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class StoreApiClient extends BaseApiClient {
    private final WebClient storeWebClient;
    private final StoreApiProperties properties;

    private static final String BASE_URL_STORE = "/B553077/api/open/sdsc2/storeListInUpjong";

    /**
     * 업종별 상가업소 요청
     * @param page ??
     * @param numOfRows ??
     *     //https://apis.data.go.kr/B553077/api/open/sdsc2/storeListInUpjong?serviceKey=KHEIPmfhDTJdwnPh0WTTMN1YOUMy9rE%2FMJGErHp2pdcfw6uzit5C7yivZg1iUbTVRLXNSgn0A%2Bdi8lCAkdv3Zg%3D%3D&pageNo=1&numOfRows=100&divId=indsSclsCd&key=D03A01&type=json"
     */
    public Mono<StorePayload.Body> fetchStore(int page, int numOfRows){
        return storeWebClient.get()
                .uri(uriBuilder -> uriBuilder.path(BASE_URL_STORE)
                        .queryParam("servicekey",properties.getStore().getAppKey())
                        .queryParam("pageNo",page)
                        .queryParam("numOfRows", numOfRows)
                        .queryParam("divId","indsSclsCd")
                        .queryParam("key","D03A01")
                        .queryParam("type","json").build())
                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<List<StorePayload.Store>>() {
//                });
                .onStatus(HttpStatus::isError, ClientResponse::createException)
                .toEntity(StorePayload.class)
                .doOnNext(this::validateStatusOk)
                .mapNotNull(ResponseEntity::getBody)
                .mapNotNull(StorePayload::getBody);
    }
}
