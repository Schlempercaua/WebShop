package org.acme.client;

import java.util.UUID;

import org.acme.dto.ProductDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@RegisterRestClient(configKey = "product-api")
public interface ProductClient {
    @GET
    @Path("/{id}")
    ProductDto getProduct(@PathParam("id") UUID productId);
}
