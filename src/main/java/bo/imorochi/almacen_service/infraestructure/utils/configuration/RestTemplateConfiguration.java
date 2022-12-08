package bo.imorochi.almacen_service.infraestructure.utils.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateConfiguration {

    @Bean("timeoutWithRequestFactory")
    RestTemplate restTemplateTimeoutWithRequestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(120000);
        requestFactory.setReadTimeout(120000);
        return new RestTemplate(requestFactory);
    }

}
