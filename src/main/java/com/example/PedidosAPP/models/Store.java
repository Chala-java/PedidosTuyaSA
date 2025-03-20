package com.example.PedidosAPP.models;

import com.example.PedidosAPP.ayudas.enums.StoreEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name="Store_Table")

public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_store")
    private Integer id_store;
    @Column (name = "name", length = 100, nullable = false)
    private String name;
    @Column (name = "address_store", length = 255, nullable = false)
    private String address;
    @Column (name = "store_category", length = 50, nullable = true)
    private String category;
    @Column (name = "store_phone", length = 20, nullable = false)
    private String phoneNumber;
    @Column (name="typestore_store",length = 50,nullable = true)
    private StoreEnum typestore;

    @OneToMany (mappedBy = "store")
    @JsonManagedReference
    private List <Order> orders;

    @OneToMany (mappedBy = "store")
    @JsonManagedReference
    private List <Product> products;

    public Store () {

    }

    public Store(Integer id_store, String name, String address, String category, String phoneNumber, StoreEnum typeStore) {
        this.id_store = id_store;
        this.name = name;
        this.address = address;
        this.category = category;
        this.phoneNumber = phoneNumber;
        this.typestore = typeStore;
    }

    public Integer getId_store() {
        return id_store;
    }

    public void setId_store(Integer id_store) {
        this.id_store = id_store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StoreEnum getTypeStore() {
        return typestore;
    }

    public void setTypeStore(StoreEnum typeStore) {
        this.typestore = typeStore;
    }
}
