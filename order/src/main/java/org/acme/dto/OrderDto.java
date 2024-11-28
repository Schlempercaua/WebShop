package org.acme.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import io.smallrye.common.constraint.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private UUID id;

    @NotNull
    private UUID customerId;

    @NotNull
    private UUID productId;

    @NotNull
    private int quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;
}
