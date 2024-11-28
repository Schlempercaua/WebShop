package org.acme.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.acme.client.CustomerClient;
import org.acme.client.ProductClient;
import org.acme.dto.OrderDto;
import org.acme.dto.ProductDto;
import org.acme.entity.Order;
import org.acme.repository.OrderRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrderService {

    @Inject
    private OrderRepository repository;

    @Inject
    @RestClient
    private CustomerClient customerClient;

    @Inject
    @RestClient
    private ProductClient productClient;

    @Transactional
    public OrderDto createOrder(OrderDto orderDto) {
        customerClient.validateCustomer(orderDto.getCustomerId());
        ProductDto product = productClient.getProduct(orderDto.getProductId());

        BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(orderDto.getQuantity()));
        orderDto.setTotalPrice(totalPrice);
        orderDto.setCreatedAt(LocalDateTime.now());

        Order order = mapDtoToEntity(orderDto);
        repository.persist(order);

        orderDto.setId(order.getId());
        return orderDto;
    }

    public List<OrderDto> findAllOrders() {
        return repository.findAll().stream().map(this::mapEntityToDto).toList();
    }

    private Order mapDtoToEntity(OrderDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setCustomerId(dto.getCustomerId());
        order.setProductId(dto.getProductId());
        order.setQuantity(dto.getQuantity());
        order.setTotalPrice(dto.getTotalPrice());
        order.setCreatedAt(dto.getCreatedAt());
        return order;
    }

    private OrderDto mapEntityToDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setCustomerId(order.getCustomerId());
        dto.setProductId(order.getProductId());
        dto.setQuantity(order.getQuantity());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setCreatedAt(order.getCreatedAt());
        return dto;
    }
}
