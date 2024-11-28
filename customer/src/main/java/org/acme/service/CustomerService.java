package org.acme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.acme.dto.CustomerDto;
import org.acme.entity.Customer;
import org.acme.repository.CustomerRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CustomerService {

    @Inject
    private CustomerRepository repository;

    @Transactional
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = mapDtoToEntity(customerDto);
        repository.persist(customer);

        customerDto.setId(customer.getId());
        return customerDto;
    }

    public List<CustomerDto> findAllCustomer() {
        List<CustomerDto> customers = new ArrayList<>();

        repository.findAll().stream().forEach(item -> {
            customers.add(mapEntityToDto(item));
        });

        return customers;
    }

    public CustomerDto findCustomerById(UUID id) {
        Customer customer = repository.findById(id);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found with id: " + id);
        }
        return mapEntityToDto(customer);
    }

    @Transactional
    public CustomerDto updateCustomer(UUID id, CustomerDto customerDto) {
        Customer customer = repository.findById(id);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found with id: " + id);
        }

        customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        customer.setAge(customerDto.getAge());

        repository.persist(customer);

        customerDto.setId(customer.getId());
        return customerDto;
    }

    @Transactional
    public void deleteCustomer(UUID id) {
        Customer customer = repository.find("id", id).firstResult();

        if (customer == null) {
            throw new IllegalArgumentException("Customer not found with id: " + id);
        }

        repository.delete(customer);
    }

    private CustomerDto mapEntityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setPhone(customer.getPhone());
        customerDto.setEmail(customer.getEmail());
        customerDto.setAddress(customer.getAddress());
        customerDto.setAge(customer.getAge());

        return customerDto;
    }

    private Customer mapDtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();

        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        customer.setAge(customerDto.getAge());

        return customer;
    }
}
