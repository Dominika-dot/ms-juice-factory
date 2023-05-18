package com.dominika.msjuicefactory.web.client;

import java.net.URI;
import java.util.UUID;

import com.dominika.msjuicefactory.web.model.CustomerDto;
import com.dominika.msjuicefactory.web.model.JuiceDto;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JuiceConsumerClientTest {


    @Autowired
    JuiceConsumerClient juiceConsumerClient;
    @Test
    void getJuiceById() {
        JuiceDto juiceDto = juiceConsumerClient.getJuiceById(UUID.randomUUID());
        assertNotNull(juiceDto);
    }

    @Test
    void saveNewJuice() {
        JuiceDto juiceDto = JuiceDto.builder().juiceName("MyJuice").build();
        val uri = juiceConsumerClient.saveNewJuice(juiceDto);
        assertNotNull(uri);
    }

    @Test
    void updateJuice() {
        JuiceDto juiceDto = JuiceDto.builder().juiceName("MyJuice").build();
        juiceConsumerClient.updateJuice(UUID.randomUUID(), juiceDto);
    }

    @Test
    void deleteJuice() {
        juiceConsumerClient.deleteJuice(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto = juiceConsumerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Dobby").build();
        URI uri = juiceConsumerClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Dobby").build();
        juiceConsumerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        juiceConsumerClient.deleteCustomer(UUID.randomUUID());
    }
}