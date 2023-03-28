package com.rutuja.CustomerApplication.Controller;

import com.rutuja.CustomerApplication.assemblers.CustomerModelAssembler;
import com.rutuja.CustomerApplication.exception.CustomerNotFoundException;
import com.rutuja.CustomerApplication.model.Customer;
import com.rutuja.CustomerApplication.repository.CustomerRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {
    private final CustomerRepository repository;
    private final CustomerModelAssembler assembler;

    public CustomerController(CustomerRepository repository, CustomerModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }
    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>>all(){
    List<EntityModel<Customer>> customers = repository.findAll()
            .stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
    return CollectionModel.of(customers,
            linkTo(methodOn(CustomerController.class).all()).withRel("customers"));
    }


    @GetMapping("/customers/{id}")
    public EntityModel<Customer> one(@PathVariable Long id){
        Customer customer = repository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException(id));
        return assembler.toModel(customer);
    }



    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer){
        return repository.save(newCustomer);
    }
    @PutMapping("/customers/{id}")
    ResponseEntity<?>replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id){

        Customer updatedCustomer = repository.findById(id)
                .map(customer -> {
            customer.setFirstname(newCustomer.getFirstname());
            customer.setLastname(newCustomer.getLastname());
            customer.setEmail(newCustomer.getEmail());
            customer.setAddress(newCustomer.getAddress());
            return repository.save(customer);
        })
                .orElseGet(()->{
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
        EntityModel<Customer> entityModel = assembler.toModel(updatedCustomer);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }
    @DeleteMapping("/customers/{id}")
       ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        repository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}
