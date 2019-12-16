package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apiHost;
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public CustomerDto getCustomer(UUID uuid) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + "/" + uuid.toString(), CustomerDto.class);
    }

    public URI createCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + "/" + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + "/" + uuid.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
