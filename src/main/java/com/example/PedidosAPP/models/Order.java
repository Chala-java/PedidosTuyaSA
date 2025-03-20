package com.example.PedidosAPP.models;

import com.example.PedidosAPP.ayudas.enums.OrderEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "Order_Table")



public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_order",length = 100,nullable = false)
    private Integer id_order;
    @Column (name = "order_state",columnDefinition = "VARCHAR(10) DEFAULT 'PENDING'")
    @Enumerated(EnumType.STRING)
    private OrderEnum state;
    @Column (name = "order_date",columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime order_date;
    @Column (name = "order_total",nullable = false)
    private BigDecimal total;



    @ManyToOne
    @JoinColumn (name = "fk_user",referencedColumnName = "id_user")
    @JsonBackReference
    private User users;

    @ManyToOne
    @JoinColumn (name = "fk_payment", referencedColumnName = "id_payment")
    @JsonBackReference
    private Payment payments;


    @ManyToOne
    @JoinColumn (name = "fk_store",referencedColumnName = "id_stores")
    @JsonBackReference
    private Store stores;

    @ManyToOne
    @JoinColumn (name = "fk_detail", referencedColumnName = "id_detail")
    @JsonBackReference
    private Detail details;

    @ManyToOne
    @JoinColumn (name = "fk_product", referencedColumnName = "id_product")
    @JsonBackReference
    private Product products;











    public Order (){

    }

    public Order(Integer id_order, OrderEnum state, LocalDateTime order_date, BigDecimal total) {
        this.id_order = id_order;
        this.state = state;
        this.order_date = order_date;
        this.total = total;
    }

    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public OrderEnum getState() {
        return state;
    }

    public void setState(OrderEnum state) {
        this.state = state;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}