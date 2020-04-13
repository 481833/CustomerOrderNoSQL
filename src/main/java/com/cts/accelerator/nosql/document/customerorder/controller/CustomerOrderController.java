package com.cts.accelerator.nosql.document.customerorder.controller;

import com.cts.accelerator.nosql.document.customerorder.domain.Customer;
import com.cts.accelerator.nosql.document.customerorder.domain.Order;
import com.cts.accelerator.nosql.document.customerorder.service.CustomerService;
import com.cts.accelerator.nosql.document.customerorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerOrderController {

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/Orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/customers/{customerName}")
    public List<Customer> getCustomerByName(@PathVariable(value="customerName") String customerName) {
        return customerService.getCustomerByName(customerName);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }


    @PostMapping("/orders")
    public Order createOrder(@RequestParam(name="customerId", required = false) String customerId, @Valid @RequestBody Order order) {
        return orderService.createOrder(customerId, order);
    }

    @GetMapping("{customerId}/orders")
    public List<Order> getOrderByCustomerId(@PathVariable String customerId) {
        return orderService.getOrderByCustomerId(customerId);
    }

    @GetMapping("/orders/{itemNumber}/orders")
    public List<Order> getOrderByItemNumber(@PathVariable String itemNumber) {
        return orderService.getOrderByItemNumber(itemNumber);
    }
}

