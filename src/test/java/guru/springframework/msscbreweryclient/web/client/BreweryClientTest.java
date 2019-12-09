package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient breweryClient;

    @Test
    void getBeerById() {
        final BeerDto beerById = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerById);
    }

    @Test
    void testSaveBeer() {
        final BeerDto newBeer = BeerDto.builder().beerName("New Beer").build();

        final URI uri = breweryClient.saveBeer(newBeer);

        assertNotNull(uri);

        System.out.println(uri);
    }
}