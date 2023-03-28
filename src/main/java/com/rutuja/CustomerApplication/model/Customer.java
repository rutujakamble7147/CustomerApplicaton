package com.rutuja.CustomerApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity

public class Customer {
    private @Id
    @GeneratedValue Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String Address;

    public Customer( String firstname,String lastname, String email, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
      this.Address = address;
    }
    public String getName(){
        return this.firstname + " " + lastname;
    }
    public void setName(String name){
        String[] parts = name.split(" ");
        this.firstname = parts[0];
        this.lastname = parts[1];
    }
}
