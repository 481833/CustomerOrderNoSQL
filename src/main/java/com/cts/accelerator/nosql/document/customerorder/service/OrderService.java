package com.cts.accelerator.nosql.document.customerorder.service;

import com.cts.accelerator.nosql.document.customerorder.RecordNotFoundException;
import com.cts.accelerator.nosql.document.customerorder.domain.Order;
import com.cts.accelerator.nosql.document.customerorder.repository.CustomerRepository;
import com.cts.accelerator.nosql.document.customerorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderByOrderId(String orderId) {
        return  orderRepository
                .findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException("Customer not found on :: " + orderId));
    }


    public List<Order> getOrderByCustomerId(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }


    public List<Order> getOrderByItemNumber(String itemNumber) {
        return orderRepository.findOrderByItemNumber(itemNumber);

    }

    public Order createOrder(String customerId, Order order) {
         return customerRepository.findByCustomerId(customerId)
                .map(customer -> {
                    order.setCustomerId(customerId);
                    return orderRepository.save(order);
                }).orElseThrow(() -> new RecordNotFoundException("Customer not found with id " + customerId));
    }

    public Order updateOrder(String orderId, Order orderRec) {

        return orderRepository.findById(orderId)
                .map(order -> {
                    return orderRepository.save(orderRec);
                }).orElseThrow(() -> new RecordNotFoundException("order not found with id " + orderId));
    }

    public void deleteOrder(String orderId) {

        Order order =
                orderRepository
                        .findById(orderId)
                        .orElseThrow(() -> new RecordNotFoundException("order not found on :: " + orderId));

        orderRepository.delete(order);
    }

}
