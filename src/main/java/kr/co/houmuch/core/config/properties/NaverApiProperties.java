package kr.co.houmuch.core.config.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConfigurationProperties("naver-api")
@ConstructorBinding
@RequiredArgsConstructor
public class NaverApiProperties {
    private final Map map;

    @Getter
    @RequiredArgsConstructor
    public static class Map {
        private final String baseUrl;
        private final String clientId;
        private final String clientSecret;
    }
}
