package com.verchetasheva.productinventory.product;

import java.math.BigDecimal;

public class ProductDTO {
    public int id;
    public String name;
    public String type;
    public BigDecimal price;
    public String description;

    public ProductDTO(int id, String name, String type, BigDecimal price, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
    }
}
