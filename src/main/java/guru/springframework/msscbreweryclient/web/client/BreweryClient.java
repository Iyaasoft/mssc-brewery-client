package guru.springframework.msscbreweryclient.web.client;


import guru.springframework.msscbreweryclient.web.config.BreweryClientConfig;
import guru.springframework.msscbreweryclient.web.model.BeerDto;
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
public class BreweryClient extends BreweryClientConfig {
    private static final String BREWERY_API = "/api/v1/beer/";

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    private String apiHost;
    RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeer(UUID beerId) {
        log.info("+++++++++  URI  "+apiHost + BREWERY_API);
        return restTemplate.getForObject(apiHost + BREWERY_API+UUID.randomUUID().toString(), BeerDto.class);
    }

    public void deleteBeer(UUID beerId) {
        log.info("+++++++++  URI  "+apiHost + BREWERY_API);
        restTemplate.delete(apiHost + BREWERY_API + beerId.toString());
    }

    public URI postBeer(BeerDto dto) {
        log.info("+++++++++  URI  "+apiHost + BREWERY_API);
        return restTemplate.postForLocation(apiHost + BREWERY_API, dto);
    }

    public void putBeer(BeerDto dto) {
        String url = apiHost + BREWERY_API + UUID.randomUUID().toString();
        log.info("+++++++++  URI  "+url );
        restTemplate.put(url , dto);
    }


}
