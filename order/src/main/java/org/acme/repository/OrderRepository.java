package org.acme.repository;

import java.util.UUID;

import org.acme.entity.Order;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order>{
    public Order findById(UUID id) {
        return find("id", id).firstResult();
    }
}
