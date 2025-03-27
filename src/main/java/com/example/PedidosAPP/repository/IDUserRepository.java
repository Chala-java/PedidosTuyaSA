package com.example.PedidosAPP.repository;

import com.example.PedidosAPP.models.Address;
import com.example.PedidosAPP.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDUserRepository extends JpaRepository <User,Integer> {


}
