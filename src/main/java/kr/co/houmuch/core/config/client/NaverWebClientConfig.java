package kr.co.houmuch.core.config.client;

import kr.co.houmuch.core.config.properties.NaverApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class NaverWebClientConfig {
    private final NaverApiProperties naverApiProperties;

    @Bean(name = "naverMapWebClient")
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(naverApiProperties.getMap().getBaseUrl())
                .defaultHeader("X-NCP-APIGW-API-KEY-ID", naverApiProperties.getMap().getClientId())
                .defaultHeader("X-NCP-APIGW-API-KEY", naverApiProperties.getMap().getClientSecret())
                .build();
    }
}
