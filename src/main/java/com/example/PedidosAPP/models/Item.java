package com.example.PedidosAPP.models;

import com.example.PedidosAPP.ayudas.enums.StoreEnum;
import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.math.BigDecimal;

@Entity
@Table (name = "Item_Table")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer id_Item;
    @Column(name = "name_item",length = 100,nullable = false)
    private String name;
    @Column(name = "price_item",nullable = false)
    private BigDecimal price;
    @Column(name = "description_item", nullable = true)
    private String description;

    public Item() {

    }

    public Item(Integer id_Item, String name, BigDecimal price, String description) {
        this.id_Item = id_Item;
        this.name = name;
        this.price = price;
        this.description = description;
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
}