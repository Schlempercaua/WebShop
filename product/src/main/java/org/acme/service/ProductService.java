package org.acme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.acme.dto.ProductDto;
import org.acme.entity.Product;
import org.acme.repository.ProductRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository repository;

    @Transactional
    public ProductDto createProduct(@Valid ProductDto productDto) {
        Product product = mapDtoToEntity(productDto);
        repository.persist(product);

        productDto.setId(product.getId());
        return productDto;
    }

    public List<ProductDto> findAllProducts() {
        List<ProductDto> products = new ArrayList<>();

        repository.findAll().stream().forEach(item -> {
            products.add(mapEntityToDto(item));
        });

        return products;
    }

    public ProductDto findProductById(UUID id) {
        Product product = repository.findById(id);
        if (product == null) {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
        return mapEntityToDto(product);
    }

    @Transactional
    public ProductDto updateProduct(UUID id, ProductDto productDto) {
        Product product = repository.findById(id);
        if (product == null) {
            throw new IllegalArgumentException("Customer not found with id: " + id);
        }

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setModel(productDto.getModel());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());

        repository.persist(product);

        productDto.setId(product.getId());
        return productDto;
    }

    @Transactional
    public void deleteProduct(UUID id) {
        Product product = repository.find("id", id).firstResult();

        if (product == null) {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }

        repository.delete(product);
    }

    private ProductDto mapEntityToDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setModel(product.getModel());
        productDto.setCategory(product.getCategory());
        productDto.setPrice(product.getPrice());

        return productDto;
    }

    private Product mapDtoToEntity(ProductDto customerDto) {
        Product product = new Product();

        product.setId(customerDto.getId());
        product.setName(customerDto.getName());
        product.setDescription(customerDto.getDescription());
        product.setModel(customerDto.getModel());
        product.setCategory(customerDto.getCategory());
        product.setPrice(customerDto.getPrice());

        return product;
    }
}
