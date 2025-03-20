package com.example.PedidosAPP.repository;

import com.example.PedidosAPP.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDStoreRepository extends JpaRepository <Store,Integer> {
}
