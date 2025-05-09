package com.example.PedidosAPP.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "Product_Table")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id_Item;
    @Column(name = "name_product",length = 100,nullable = false)
    private String name;
    @Column(name = "price_product",nullable = false)
    private BigDecimal price;
    @Column(name = "description_product", nullable = true)
    private String description;

    @ManyToOne
    @JsonBackReference(value = "store-products")
    @JoinColumn(name = "fk_store", referencedColumnName = "id_store")
    private Store stores;

    @ManyToOne
    @JsonBackReference(value = "details-products")
    @JoinColumn(name = "fk_detail", referencedColumnName = "id_detail")
    private Detail details;



    public Product() {

    }

    public Product(Integer id_Item, String name, BigDecimal price, String description, Store stores, Detail details) {
        this.id_Item = id_Item;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stores = stores;
        this.details = details;
    }

    public Integer getId_Item() {
        return id_Item;
    }

    public void setId_Item(Integer id_Item) {
        this.id_Item = id_Item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Store getStores() {
        return stores;
    }

    public void setStores(Store stores) {
        this.stores = stores;
    }

    public Detail getDetails() {
        return details;
    }

    public void setDetails(Detail details) {
        this.details = details;
    }
}