package com.example.PedidosAPP.models;

import com.example.PedidosAPP.ayudas.enums.DealerEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "Dealer_Table")

public class Dealer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_dealer")
    private Integer dealer;
    @Column(name = "name_dealer",length = 100, nullable = false)
    private String name_dealer;
    @Column(name = "phone_dealer",length = 20, nullable = false)
    private String phone_dealer;
    @Column(name = "email_dealer",length = 150, unique = true,nullable = false)
    private String email;
    @Column(name = "type_dealer",length = 50, nullable = true)
    private DealerEnum type_dealer;

    public Dealer () {
    }

    public Dealer(Integer dealer, String name_dealer, String phone_dealer, String email, DealerEnum type_dealer) {
        this.dealer = dealer;
        this.name_dealer = name_dealer;
        this.phone_dealer = phone_dealer;
        this.email = email;
        this.type_dealer = type_dealer;
    }

    public Integer getDealer() {
        return dealer;
    }

    public void setDealer(Integer dealer) {
        this.dealer = dealer;
    }

    public String getName_dealer() {
        return name_dealer;
    }

    public void setName_dealer(String name_dealer) {
        this.name_dealer = name_dealer;
    }

    public String getPhone_dealer() {
        return phone_dealer;
    }

    public void setPhone_dealer(String phone_dealer) {
        this.phone_dealer = phone_dealer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DealerEnum getType_dealer() {
        return type_dealer;
    }

    public void setType_dealer(DealerEnum type_dealer) {
        this.type_dealer = type_dealer;
    }
}
