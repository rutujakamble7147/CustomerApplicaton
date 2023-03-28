package com.rutuja.CustomerApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Customer_Order")
public class Order {
    private @Id
    @GeneratedValue Long id;
    private String CustomerName;
    private Status status;

    public Order( String customerName, Status status) {

        CustomerName = customerName;
        this.status = status;
    }
}
