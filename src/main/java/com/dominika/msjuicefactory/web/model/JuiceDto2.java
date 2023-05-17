package com.dominika.msjuicefactory.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JuiceDto2 {

    private UUID id;
    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
    private String beerName;
    private JuiceStyleEnum juiceStyle;
    private Long upc;
    private BigDecimal price;
    private Integer quantityOnHand;
}
