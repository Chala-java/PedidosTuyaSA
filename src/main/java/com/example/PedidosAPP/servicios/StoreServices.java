package com.example.PedidosAPP.servicios;


import com.example.PedidosAPP.models.Store;
import com.example.PedidosAPP.repository.IDStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServices {

    @Autowired
    IDStoreRepository repository;

    //Metodo guardar

    public Store dataStore(Store storeSave) throws Exception {
        try {
            return this.repository.save(storeSave);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

















































}













