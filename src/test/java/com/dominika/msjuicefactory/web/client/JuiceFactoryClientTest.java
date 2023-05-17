package com.dominika.msjuicefactory.web.client;

import java.util.UUID;

import com.dominika.msjuicefactory.web.model.JuiceDto;
import com.dominika.msjuicefactory.web.model.JuiceDto2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JuiceFactoryClientTest {


    @Autowired
    JuiceFactoryClient juiceFactoryClient;
    @Test
    void getJuiceById() {
        JuiceDto juiceDto = juiceFactoryClient.getJuiceById(UUID.randomUUID());
        assertNotNull(juiceDto);
    }
}