package com.dominika.msjuicefactory.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class JuiceDto {
    private UUID id;
    private String juiceName;
    private String juiceStyle;
    private Long upc;
}
