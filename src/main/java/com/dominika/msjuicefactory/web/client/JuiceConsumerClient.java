package com.dominika.msjuicefactory.web.client;

import java.net.URI;
import java.util.UUID;

import com.dominika.msjuicefactory.web.model.CustomerDto;
import com.dominika.msjuicefactory.web.model.JuiceDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JuiceConsumerClient {

    public final String JUICE_PATH_V1 = "/api/v1/juice";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer";
    @Value("${dg.juiceconsumer.apihost}")
    private String apihost;
    public final RestTemplate restTemplate;

    public JuiceConsumerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public JuiceDto getJuiceById(UUID uuid) {
        return restTemplate.getForObject(apihost + JUICE_PATH_V1 +"/"+ uuid, JuiceDto.class);
    }

    public URI saveNewJuice (JuiceDto juiceDto){
        return restTemplate.postForLocation(apihost+JUICE_PATH_V1, juiceDto);
    }

    public void updateJuice (UUID id, JuiceDto juiceDto){
        restTemplate.put(apihost+JUICE_PATH_V1+"/"+id, juiceDto);
    }

    public void deleteJuice(UUID id){
        restTemplate.delete(apihost+JUICE_PATH_V1+"/"+id);
    }

    public CustomerDto getCustomerById(UUID uuid) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 +"/"+ uuid, CustomerDto.class);
    }

    public URI saveNewCustomer (CustomerDto customerDto){
        return restTemplate.postForLocation(apihost+ CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer (UUID id, CustomerDto customerDto){
        restTemplate.put(apihost+ CUSTOMER_PATH_V1 +"/"+id, customerDto);
    }

    public void deleteCustomer(UUID id){
        restTemplate.delete(apihost+ CUSTOMER_PATH_V1 +"/"+id);
    }

}
