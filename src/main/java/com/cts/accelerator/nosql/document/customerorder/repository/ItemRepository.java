package com.cts.accelerator.nosql.document.customerorder.repository;

import com.cts.accelerator.nosql.document.customerorder.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
