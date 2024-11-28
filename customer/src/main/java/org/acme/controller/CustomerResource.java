package org.acme.controller;

import java.util.List;
import java.util.UUID;

import org.acme.dto.CustomerDto;
import org.acme.service.CustomerService;

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

@Path("/api/v1/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    private CustomerService customerService;

    @POST
    public Response createCustomer(@Valid CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.createCustomer(customerDto);
        return Response.status(Response.Status.CREATED).entity(createdCustomer).build();
    }

    @GET
    public List<CustomerDto> listAllCustomers() {
        return customerService.findAllCustomer();
    }

    @GET
    @Path("/{id}")
    public Response listCustomerById(@PathParam("id") UUID id) {
        CustomerDto customer = customerService.findCustomerById(id);
        return Response.ok(customer).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") UUID id, @Valid CustomerDto customerDto) {
        CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);
        return Response.accepted().entity(updatedCustomer).build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") UUID id) {
        customerService.deleteCustomer(id);
        return Response.noContent().build();
    }
}
