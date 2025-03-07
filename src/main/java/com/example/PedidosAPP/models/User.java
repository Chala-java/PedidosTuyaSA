package com.example.PedidosAPP.models;

import com.example.PedidosAPP.ayudas.enums.UserEnum;
import jakarta.persistence.*;

@Entity
@Table(name="User_table")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long id;
    @Column(name = "name_user", length = 100, nullable = false)
    private String name;
    @Column(name = "email_user", length = 150, unique = true, nullable = false)
    private String email;

    @Column (name = "password_user", length = 225,  nullable = false)
    private String password;
    @Column (name = "phone_number",length = 20, nullable = true)
    private String phoneNumber;
    @Column (name = "type_user",length = 50, nullable = false)
    private UserEnum typeUSer;

    public User() {

    }

    public User(long id, String name, String email, String password, String phoneNumber, UserEnum typeUSer) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.typeUSer = typeUSer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserEnum getTypeUSer() {
        return typeUSer;
    }

    public void setTypeUSer(UserEnum typeUSer) {
        this.typeUSer = typeUSer;
    }
}
