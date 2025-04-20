package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.models.Detail;
import com.example.PedidosAPP.repository.IDDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailServices {
    @Autowired
    IDDetailRepository repository;

    public Detail saveDetail(Detail dataDetail) throws Exception {
        try {
           return this.repository.save(dataDetail);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Detail> searchAllOrder() throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Detail searchOrderByID (Integer idDetail) throws Exception{
        try {
            Optional<Detail> searchDetail = this.repository.findById(idDetail);
            if (searchDetail.isPresent()){
                return searchDetail.get();
            }else{
                throw new Exception("detalle no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Detail modifyDetail (Integer idDetail,Detail dataDetail) throws Exception{
        try {
            Optional<Detail> searchDetail = this.repository.findById(idDetail);
            if (searchDetail.isPresent()){
                searchDetail.get().setQuantity(dataDetail.getQuantity());
                searchDetail.get().setSubtotal(dataDetail.getSubtotal());
                return this.repository.save(dataDetail);
            }else{
                throw new Exception("detalle no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteDetail(Integer id) throws Exception{
        try {
            Optional<Detail> searchDetail = this.repository.findById(id);
            if (searchDetail.isPresent()){
                 this.repository.deleteById(id);
                 return true;
            }else {
                throw new Exception("detalle no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
















































}
