package com.example.PedidosAPP.servicios;


import com.example.PedidosAPP.models.Store;
import com.example.PedidosAPP.models.User;
import com.example.PedidosAPP.repository.IDStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServices {

    @Autowired
    IDStoreRepository repository;

    //Metodo guardar

    public Store saveStore(Store storeSave) throws Exception {
        try {
            return this.repository.save(storeSave);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Metodo buscar todos

    public List<Store> searchAllStore() throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    public Store searchAllStoreById(Integer idStore) throws Exception{
        try {
            Optional <Store> searchStore = this.repository.findById(idStore);
            if (searchStore.isPresent()){
                return searchStore.get();
            } else {
                throw new Exception("El usuario no ha sido encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Store modifyStore(Integer idStore, Store dataStore) throws Exception{
        try {
            Optional <Store> searchStore = this.repository.findById(idStore);
            if (searchStore.isPresent()){
                searchStore.get().setPhoneNumber(dataStore.getPhoneNumber());
                searchStore.get().setAddress(dataStore.getAddress());
                return this.repository.save(searchStore.get());
            }else {
                throw new Exception("tienda no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteStore(Integer id) throws Exception{
        try {
            Optional <Store> searchStore = this.repository.findById(id);
            if (searchStore.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception("tienda no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
















































}













