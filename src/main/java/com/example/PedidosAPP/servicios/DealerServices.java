package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.models.Dealer;
import com.example.PedidosAPP.repository.IDDealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealerServices {

    @Autowired
    IDDealerRepository repository;

    public Dealer saveDealer (Dealer dataDealer)throws Exception{
        try {
           return this.repository.save(dataDealer);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List <Dealer> searchAllDealer() throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Dealer searchDealerById(Integer idDealer) throws Exception{
        try {
            Optional<Dealer> searchDealer = this.repository.findById(idDealer);
            if (searchDealer.isPresent()){
                return searchDealer.get();
            }else {
                throw new Exception("dealer no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Dealer modifyDealer(Integer idDealer, Dealer dataDealer)throws Exception{
        try {
            Optional<Dealer> searchDealer = this.repository.findById(idDealer);
            if (searchDealer.isPresent()){
                searchDealer.get().setEmail(dataDealer.getEmail());
                searchDealer.get().setDealer(dataDealer.getDealer());
                searchDealer.get().setName_dealer(dataDealer.getName_dealer());
                searchDealer.get().setPhone_dealer(dataDealer.getPhone_dealer());
                searchDealer.get().setType_dealer(dataDealer.getType_dealer());
                return this.repository.save(dataDealer);
            }else{
                throw new Exception("dealer no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteDealer(Integer id)throws Exception {
        try {
            Optional<Dealer> searchDealer = this.repository.findById(id);
            if (searchDealer.isPresent()) {
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception("dealer no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }















}
