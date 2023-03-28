package com.rutuja.CustomerApplication.assemblers;

import com.rutuja.CustomerApplication.Controller.CustomerController;
import com.rutuja.CustomerApplication.model.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@Configuration
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

    @Override
    public EntityModel <Customer> toModel(Customer customer){
        return EntityModel.of(customer,
                linkTo(methodOn(CustomerController.class).one(customer.getId())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).all()).withRel("customers"));
    }
}
