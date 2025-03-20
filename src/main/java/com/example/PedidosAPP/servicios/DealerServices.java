package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.repository.IDDealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerServices {

    @Autowired
    IDDealerRepository repository;
}
