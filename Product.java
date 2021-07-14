package com.verchetasheva.productinventory.product;

import com.verchetasheva.productinventory.inventory.Inventory;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {
    private Object GenerationType;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String type;
    public BigDecimal price;
    public String description;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    public Inventory inventory;

    public Product(){}

    public Product(int id, String name, String type, BigDecimal price, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description=description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(10);
    }

    @Override
    public String toString() {

        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

}

