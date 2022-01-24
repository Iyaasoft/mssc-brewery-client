package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;
    @Test
    void getCustomer() {
        CustomerDto dto = client.getCustomer(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveCustomer() {
        URI uri = client.saveCustomer(CustomerDto.builder().name("Tony Stark").build());
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        client.updateCustomer(CustomerDto.builder().name("Tony Starks Son").build());

    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());

    }
}