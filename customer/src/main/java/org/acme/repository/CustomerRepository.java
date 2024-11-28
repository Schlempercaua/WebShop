package org.acme.repository;

import java.util.UUID;

import org.acme.entity.Customer;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
    public Customer findById(UUID id) {
        return find("id", id).firstResult();
    }
}
