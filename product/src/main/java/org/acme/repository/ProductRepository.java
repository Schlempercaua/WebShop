package org.acme.repository;

import java.util.UUID;

import org.acme.entity.Product;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product>{
    public Product findById(UUID id) {
        return find("id", id).firstResult();
    }
}
