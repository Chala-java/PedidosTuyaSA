package com.example.PedidosAPP.models;

import com.example.PedidosAPP.ayudas.enums.DeliveryEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "Delivery_Table")

public class Delivery {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_delivery")
    private Integer delivery;
    @Column (name = "delivery_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime delivery_date;
    @Column(name="status_delivery", columnDefinition = "VARCHAR(10) DEFAULT 'ASSIGNED' ")
    private DeliveryEnum delivery_status;

    @ManyToOne
    @JsonBackReference
    @JoinColumn (name = "fk_dealer", referencedColumnName = "id_dealer")
    private Dealer dealers;


    public Delivery (){

    }

    public Delivery(Integer delivery, LocalDateTime delivery_date, DeliveryEnum delivery_status) {
        this.delivery = delivery;
        this.delivery_date = delivery_date;
        this.delivery_status = delivery_status;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public LocalDateTime getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(LocalDateTime delivery_date) {
        this.delivery_date = delivery_date;
    }

    public DeliveryEnum getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(DeliveryEnum delivery_status) {
        this.delivery_status = delivery_status;
    }
}

