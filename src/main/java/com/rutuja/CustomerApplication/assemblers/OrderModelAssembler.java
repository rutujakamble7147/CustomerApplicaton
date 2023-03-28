package com.rutuja.CustomerApplication.assemblers;

import com.rutuja.CustomerApplication.Controller.OrderController;
import com.rutuja.CustomerApplication.model.Order;
import com.rutuja.CustomerApplication.model.Status;
import com.rutuja.CustomerApplication.repository.OrderRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@Configuration
public class OrderModelAssembler implements RepresentationModelAssembler<Order,EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order){
        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        if (order.getStatus()== Status.IN_PROGRESS){
            orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
            orderModel.add(linkTo(methodOn(OrderController.class).complete(order.getId())).withRel("complete"));

        }
        return orderModel;

    }
}
