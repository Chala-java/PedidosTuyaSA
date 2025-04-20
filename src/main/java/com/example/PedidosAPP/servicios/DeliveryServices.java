package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.models.Delivery;
import com.example.PedidosAPP.repository.IDDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServices {

    @Autowired
    IDDeliveryRepository repository;

    public Delivery saveDelivery (Delivery dataDelivery) throws Exception{
        try {
          return this.repository.save(dataDelivery);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Delivery> searchAllDelivery () throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Delivery searchDeliveryById (Integer idDelivery) throws Exception{
        try {
            Optional<Delivery> searchDelivery = this.repository.findById(idDelivery);
            if (searchDelivery.isPresent()){
                return searchDelivery.get();
            }else {
                throw new Exception("delivery no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Delivery modifyDelivery (Integer idDelivery, Delivery dataDelivery) throws Exception{
        try {
            Optional<Delivery> searchDelivery = this.repository.findById(idDelivery);
            if (searchDelivery.isPresent()){
                searchDelivery.get().setDelivery(dataDelivery.getDelivery());
                searchDelivery.get().setDelivery_date(dataDelivery.getDelivery_date());
                searchDelivery.get().setDelivery_status(dataDelivery.getDelivery_status());
                return this.repository.save(dataDelivery);
            }else {
                throw new Exception("delivery no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteDelivery (Integer id) throws Exception{
        try {
            Optional<Delivery> searchDelivery = this.repository.findById(id);
            if (searchDelivery.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("delivery no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }



































}
