package com.cts.accelerator.nosql.document.customerorder.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("Item")
public class Item  {

    @Id
    private String id;

    @Field("itemNumber")
    @Indexed(name="itemNumber")
    private String itemNumber;
    @Field("description")
    private String description;
    @Field("itemPrice")
    private Double itemPrice;

    public Item() {
    }

    public Item(String itemNumber, String description, Double itemPrice) {
        this.itemNumber = itemNumber;
        this.description = description;
        this.itemPrice = itemPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
