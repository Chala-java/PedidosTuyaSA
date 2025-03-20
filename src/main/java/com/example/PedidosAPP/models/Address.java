package com.example.PedidosAPP.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Address_Table")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Integer id_address;
    @Column(name = "street_address",length = 225, nullable = false)
    private String street;
    @Column(name = "city_address",length = 100,nullable = false)
    private String city;
    @Column(name = "postcode_address",length = 20,nullable = false)
    private String postcode;
    @Column(name = "country_address",length = 50, nullable = false)
    private String country;

    public Address(Integer id_address, String street, String city, String postcode, String country) {
        this.id_address = id_address;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

    @ManyToOne
    @JoinColumn (name = "fk_user",referencedColumnName = "id_user")
    @JsonBackReference
    private User users;

    public Integer getId_address() {
        return id_address;
    }

    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
