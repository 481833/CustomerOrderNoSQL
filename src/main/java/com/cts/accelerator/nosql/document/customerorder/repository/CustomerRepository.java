package com.cts.accelerator.nosql.document.customerorder.repository;

import com.cts.accelerator.nosql.document.customerorder.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findByName(String name);

    @Query(value = "{'_id': ?0}")
    Optional<Customer> findByCustomerId(String customerId);
}
