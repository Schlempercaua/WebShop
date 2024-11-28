package org.acme.controller;

import java.util.List;

import org.acme.dto.OrderDto;
import org.acme.service.OrderService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    private OrderService orderService;

    @POST
    @RolesAllowed({"user", "admin"})
    public Response createOrder(@Valid OrderDto orderDto) {
        OrderDto createdOrder = orderService.createOrder(orderDto);
        return Response.status(Response.Status.CREATED).entity(createdOrder).build();
    }

    @GET
    @RolesAllowed({"admin"})
    public List<OrderDto> listAllOrders() {
        return orderService.findAllOrders();
    }
}


