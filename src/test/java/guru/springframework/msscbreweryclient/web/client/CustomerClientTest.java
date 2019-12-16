package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;

    private CustomerDto customerDto;

    @BeforeEach
    void setUp() {
        customerDto = CustomerDto.builder()
                .name("DDL")
                .build();
    }

    @Test
    void getCustomer() {
        final CustomerDto customer = customerClient.getCustomer(UUID.randomUUID());

        assertNotNull(customer);
    }

    @Test
    void createCustomer() {
        final URI uri = customerClient.createCustomer(customerDto);

        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void updateCustomer() {
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}