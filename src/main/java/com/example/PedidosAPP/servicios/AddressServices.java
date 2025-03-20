package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.repository.IDAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServices {

    @Autowired
    IDAddressRepository repository;
}
