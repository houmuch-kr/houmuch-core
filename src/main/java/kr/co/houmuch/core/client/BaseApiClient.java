package kr.co.houmuch.core.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

public abstract class BaseApiClient {
    protected void validateStatusOk(ResponseEntity<?> responseEntity) {
        HttpStatus httpStatus = responseEntity.getStatusCode();
        if (httpStatus.is4xxClientError()) {
            throw new HttpClientErrorException(httpStatus);
        }
        if (httpStatus.is5xxServerError()) {
            throw new HttpServerErrorException(httpStatus);
        }
        if (!responseEntity.hasBody()) {
            throw new IllegalArgumentException();
        }
    }
}
