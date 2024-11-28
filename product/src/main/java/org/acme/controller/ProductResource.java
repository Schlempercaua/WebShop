package org.acme.controller;

import java.util.List;
import java.util.UUID;

import org.acme.dto.ProductDto;
import org.acme.service.ProductService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductService productService;

    @POST
    public Response createProduct(@Valid ProductDto productDto) {
        ProductDto createdProduct = productService.createProduct(productDto);
        return Response.status(Response.Status.CREATED).entity(createdProduct).build();
    }

    @GET
    public List<ProductDto> listAllProducts() {
        return productService.findAllProducts();
    }

    @GET
    @Path("/{id}")
    public Response listProductById(@PathParam("id") UUID id) {
        ProductDto Product = productService.findProductById(id);
        return Response.ok(Product).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") UUID id, @Valid ProductDto productDto) {
        ProductDto updatedCustomer = productService.updateProduct(id, productDto);
        return Response.accepted().entity(updatedCustomer).build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") UUID id) {
        productService.deleteProduct(id);
        return Response.noContent().build();
    }
}
