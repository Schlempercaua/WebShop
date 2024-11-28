package org.acme.client;

import java.util.UUID;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@RegisterRestClient(configKey = "customer-api")
public interface CustomerClient {
    @GET
    @Path("/{id}")
    void validateCustomer(@PathParam("id") UUID customerId);
}

