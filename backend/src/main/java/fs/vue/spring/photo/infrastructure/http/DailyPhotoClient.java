package fs.vue.spring.photo.infrastructure.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DailyPhotoClient {

    private static final String SERVICE_PATH = "/planetary/apod";
    private final RestTemplate restTemplate;
    private final String apiToken;

    public DailyPhotoClient(RestTemplate restTemplate, @Value("${nasa.api.key}") String apiToken) {
        this.restTemplate = restTemplate;
        this.apiToken = apiToken;
    }

    public DailyPhotoDto getDailyPhoto() {
        return restTemplate.getForObject(SERVICE_PATH + "?api_key=" + apiToken, DailyPhotoDto.class);
    }
}
