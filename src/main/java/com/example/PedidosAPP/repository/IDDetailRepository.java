package com.example.PedidosAPP.repository;

import com.example.PedidosAPP.models.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDDetailRepository extends JpaRepository <Detail,Integer> {

}
