package kr.co.houmuch.core.config.client;

import kr.co.houmuch.core.config.properties.StoreApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
@RequiredArgsConstructor
public class StoreWebClientConfig {
    private final StoreApiProperties storeApiProperties;

    @Bean(name = "storeWebClient")
    public WebClient webClient() {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(storeApiProperties.getStore().getBaseUrl());
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        return WebClient.builder()
                .uriBuilderFactory(factory)
                .baseUrl(storeApiProperties.getStore().getBaseUrl())
                .build();
    }
}
