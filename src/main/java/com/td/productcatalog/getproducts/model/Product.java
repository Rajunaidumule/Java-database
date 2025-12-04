package com.td.productcatalog.getproducts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @Id
    private Integer productNumber;
    private String productName;
    private BigDecimal productValue;
}
