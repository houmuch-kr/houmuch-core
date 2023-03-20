package kr.co.houmuch.core.config;

import kr.co.houmuch.core.config.properties.NaverApiProperties;
import kr.co.houmuch.core.config.properties.StoreApiProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableConfigurationProperties({
        NaverApiProperties.class,
        StoreApiProperties.class
})
@EnableJpaAuditing
public class CommonCoreConfig {
}
