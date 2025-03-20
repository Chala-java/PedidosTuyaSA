package com.example.PedidosAPP.repository;

import com.example.PedidosAPP.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDProductRepository extends JpaRepository <Product, Integer> {
}
