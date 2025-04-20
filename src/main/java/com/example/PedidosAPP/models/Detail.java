package com.example.PedidosAPP.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table (name = "Detail_Table")

public class Detail {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_detail")
    private Integer id_detail;
    @Column (name = "quantity_detail",nullable = false)
    private Integer quantity;
    @Column (name = "subtotal_detail",nullable = false)
    private BigDecimal subtotal;

    @OneToMany (mappedBy = "details")
    @JsonManagedReference(value = "detail-order")
    private List <Order> orders;

    @OneToMany (mappedBy = "details")
    @JsonManagedReference(value = "details-products")
    private List <Product> products;


    public Detail (){

    }

    public Detail(Integer id_detail, Integer quantity, BigDecimal subtotal) {
        this.id_detail = id_detail;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Integer getId_detail() {
        return id_detail;
    }

    public void setId_detail(Integer id_detail) {
        this.id_detail = id_detail;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}