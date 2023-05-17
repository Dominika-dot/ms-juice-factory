package com.dominika.msjuicefactory.web.client;

import java.util.UUID;

import com.dominika.msjuicefactory.web.model.JuiceDto;
import com.dominika.msjuicefactory.web.model.JuiceDto2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JuiceFactoryClient {

    public final String JUICE_PATH_V1 = "/api/v1/juice/";
    @Value("${dg.juicefactory.apihost}")
    private String apihost;
    public final RestTemplate restTemplate;
    public JuiceFactoryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public JuiceDto getJuiceById(UUID uuid){
        return restTemplate.getForObject(apihost + JUICE_PATH_V1 + uuid, JuiceDto.class);
    }

    public void setApihost(String apihost){
        this.apihost=apihost;
    }
}
