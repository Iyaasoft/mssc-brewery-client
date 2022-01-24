package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    // todo complete tests  test stubs
    @Test
    void getBeer() {
        BeerDto dto = breweryClient.getBeer(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void postBeer() {
        URI location = breweryClient.postBeer(
                BeerDto.builder()
                        .beerName("Guiness")
                        .beerStyle("Dark Stout")
                        .build());
        assertNotNull(location);

    }

    @Test
    void putBeer() {
        breweryClient.putBeer(
                BeerDto.builder()
                        .beerName("Heiniken")
                        .beerStyle("Larger")
                        .build());
    }
}