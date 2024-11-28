package org.acme.dto;

import java.math.BigDecimal;
import java.util.UUID;

import io.smallrye.common.constraint.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private UUID id;
    
    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String category;

    @NotNull
    private String model;

    @NotNull
    private BigDecimal price;
}
