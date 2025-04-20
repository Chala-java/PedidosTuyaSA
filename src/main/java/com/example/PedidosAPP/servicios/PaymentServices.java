package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.models.Payment;
import com.example.PedidosAPP.repository.IDPaymentRepository;
import com.example.PedidosAPP.repository.IDProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServices {

    @Autowired
    IDPaymentRepository repository;

    public Payment savePayment(Payment dataPayment)throws Exception{
        try {
            return this.repository.save(dataPayment);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Payment> searchAllPayment() throws Exception{
        try {
          return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Payment searchAllPaymentById(Integer idPayment) throws Exception{
        try {
            Optional<Payment> searchPayment=this.repository.findById(idPayment);
            if (searchPayment.isPresent());
            return searchPayment.get();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Payment modifyPayment(Integer idPayment, Payment dataPayment) throws Exception{
        try {
            Optional<Payment> searchPayment=this.repository.findById(idPayment);
            if (searchPayment.isPresent()) {
            searchPayment.get().setPayment_method(dataPayment.getPayment_method());
            searchPayment.get().setPayment_status(dataPayment.getPayment_status());
            return this.repository.save(dataPayment);
        }else{
                throw new Exception("pago no encontrado");
            }
    }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deletePayment(Integer id) throws Exception{
        try {
            Optional<Payment> searchPayment=this.repository.findById(id);
            if (searchPayment.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }















































}
