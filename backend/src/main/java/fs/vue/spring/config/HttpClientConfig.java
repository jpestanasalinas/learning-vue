package fs.vue.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {

    private final String nasaUrl;

    public HttpClientConfig(@Value("${nasa.api.url}") String nasaUrl) {
        this.nasaUrl = nasaUrl;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.rootUri(nasaUrl).build();
    }
}
