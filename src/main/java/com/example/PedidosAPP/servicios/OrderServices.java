package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.repository.IDOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServices {

    @Autowired
    IDOrderRepository repository;
}
