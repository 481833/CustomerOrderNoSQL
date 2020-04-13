package com.cts.accelerator.nosql.document.customerorder.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document("Order")
public class Order {

    @Id
    private String orderId;

    // Customer Id of the Customer collection
    @Field("customerId")
    private String customerId;
    @Field("orderDate")
    private Date orderDate;
    @Field("shippingDate")
    private Date shippingDate;
    @Field("orderStatus")
    private String orderStatus;

    @Field("items")
    private List items;

    @Field("payments")
    private List payments;

    public Order() {

    }

    public Order(String customerId, Date orderDate, Date shippingDate, String orderStatus, List items, List payments) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
        this.orderStatus = orderStatus;
        this.items = items;
        this.payments = payments;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public List getPayments() {
        return payments;
    }

    public void setPayments(List payments) {
        this.payments = payments;
    }
}
