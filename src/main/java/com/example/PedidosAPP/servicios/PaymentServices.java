package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.repository.IDPaymentRepository;
import com.example.PedidosAPP.repository.IDProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {

    @Autowired
    IDPaymentRepository repository;
}
