package org.acme.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private UUID id;

    private String name;

    private String description;

    private String category;

    private String model;

    private BigDecimal price;
}