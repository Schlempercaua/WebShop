package org.acme.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private UUID customerId;

    @NotNull
    private UUID productId;

    @NotNull
    private int quantity;

    @NotNull
    private BigDecimal totalPrice;

    private LocalDateTime createdAt;
}
