package kr.co.houmuch.core.config.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConfigurationProperties("store-api")
@ConstructorBinding
@RequiredArgsConstructor
public class StoreApiProperties {
    private final Store store;

    @Getter
    @RequiredArgsConstructor
    public static class Store {
        private final String baseUrl;
        private final String appKey;
    }
}
