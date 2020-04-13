package com.cts.accelerator.nosql.document.customerorder.repository;

import com.cts.accelerator.nosql.document.customerorder.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    @Query(value = "{'items.itemNumber': ?0}")
    List<Order> findOrderByItemNumber(String itemNumber);

    List<Order> findByCustomerId(String customerId);
}
