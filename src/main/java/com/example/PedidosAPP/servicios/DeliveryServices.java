package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.repository.IDDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServices {

    @Autowired
    IDDeliveryRepository repository;
}
