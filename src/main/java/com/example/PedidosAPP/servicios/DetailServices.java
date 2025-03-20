package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.repository.IDDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServices {
    @Autowired
    IDDetailRepository repository;
}
