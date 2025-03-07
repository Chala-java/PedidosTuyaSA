package com.example.PedidosAPP.models;

import com.example.PedidosAPP.ayudas.enums.PaymentMethodEnum;
import com.example.PedidosAPP.ayudas.enums.PaymentstatusEnum;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table (name = "Payment_Table")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Integer id_payment;
    @Column(name = "paymentMethod", length = 50, nullable = false)
    private PaymentMethodEnum payment_method;
    @Column(name = "paymentstatus", columnDefinition = "VARCHAR(10) DEFAULT 'PENDING'")
    private PaymentstatusEnum payment_status;
    @Column(name = "payment_data", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime payment_date;

    public Payment() {

    }

    public Payment(Integer id_payment, PaymentMethodEnum payment_method, PaymentstatusEnum payment_status, LocalDateTime payment_date) {
        this.id_payment = id_payment;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
        this.payment_date = payment_date;
    }

    public Integer getId_payment() {
        return id_payment;
    }

    public void setId_payment(Integer id_payment) {
        this.id_payment = id_payment;
    }

    public PaymentMethodEnum getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(PaymentMethodEnum payment_method) {
        this.payment_method = payment_method;
    }

    public PaymentstatusEnum getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(PaymentstatusEnum payment_status) {
        this.payment_status = payment_status;
    }

    public LocalDateTime getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }
}