package guru.springframework.msscbreweryclient.web.client;


import guru.springframework.msscbreweryclient.web.config.BreweryClientConfig;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Slf4j
@Component
public class CustomerClient extends BreweryClientConfig {

    private RestTemplate restTemplate;

    private static final String CUSTOMER_API ="/api/v1/customer/";

    private String apiHost;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public CustomerDto getCustomer(UUID id) {
        String url = apiHost + CUSTOMER_API + UUID.randomUUID().toString();
        log.info("+++++++  "+url);
        return restTemplate.getForObject(apiHost+CUSTOMER_API+UUID.randomUUID(),CustomerDto.class);
    }

    public URI saveCustomer(CustomerDto customerDto) {
        String url = apiHost + CUSTOMER_API ;
        log.info("+++++++  "+url);
        return restTemplate.postForLocation(apiHost+CUSTOMER_API,customerDto);
    }

    public void updateCustomer(CustomerDto customerDto) {
        String url = apiHost + CUSTOMER_API + UUID.randomUUID().toString();
        log.info("+++++++  "+url);
        restTemplate.put(apiHost+CUSTOMER_API+UUID.randomUUID(), customerDto);
    }

    public void deleteCustomer(UUID id) {
        String url = apiHost + CUSTOMER_API + id.toString();
        log.info("+++++++  "+url);
        restTemplate.delete(apiHost+CUSTOMER_API+id);
    }
}
