package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.repository.IDUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    IDUserRepository repository;
}
