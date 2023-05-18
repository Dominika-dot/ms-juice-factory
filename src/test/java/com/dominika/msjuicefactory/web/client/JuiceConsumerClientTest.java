package com.dominika.msjuicefactory.web.client;

import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;

import com.dominika.msjuicefactory.web.model.CustomerDto;
import com.dominika.msjuicefactory.web.model.JuiceDto;
import com.dominika.msjuicefactory.web.model.JuiceStyleEnum;
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
        val uri = juiceConsumerClient.saveNewJuice(getValidJuiceDto());
        assertNotNull(uri);
    }

    @Test
    void updateJuice() {
        juiceConsumerClient.updateJuice(UUID.randomUUID(), getValidJuiceDto());
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

    JuiceDto getValidJuiceDto(){
        return JuiceDto.builder()
            .juiceName("Orange juice")
            .juiceStyle(JuiceStyleEnum.FRESH)
            .price(new BigDecimal("10.22"))
            .upc(1526342563765L)
            .build();
    }
}