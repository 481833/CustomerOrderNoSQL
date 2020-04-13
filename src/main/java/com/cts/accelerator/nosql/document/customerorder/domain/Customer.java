package com.cts.accelerator.nosql.document.customerorder.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("Customer")
public class Customer {

    @Id
    private String customerId;

    @Field("name")
    @Indexed(name="customerName")
    private String name;

    @Field("orders")
    private List orders;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
    }

    public Customer(String name, List orders) {
        this.name = name;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getOrders() {
        return orders;
    }

    public void setOrders(List orders) {
        this.orders = orders;
    }
}


