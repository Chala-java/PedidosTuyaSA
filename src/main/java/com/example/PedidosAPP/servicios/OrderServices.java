package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.models.Order;
import com.example.PedidosAPP.repository.IDOrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    IDOrderRepository repository;

    public Order saveOrder(Order dataOrder) throws Exception{
        try {
            return this.repository.save(dataOrder);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Order> searchAllOrder() throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Order searchAllOrderById(Integer idOrder) throws Exception {
        try {
            Optional<Order> searchOrder = this.repository.findById(idOrder);
            if (searchOrder.isPresent());
                return searchOrder.get();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Order modifyOrder(Integer idOrder, Order dataOrder) throws Exception {
        try {
            Optional<Order> searchOrder = this.repository.findById(idOrder);
            if (searchOrder.isPresent()) {
                searchOrder.get().setOrder_date(dataOrder.getOrder_date());
                searchOrder.get().setState(dataOrder.getState());
                searchOrder.get().setTotal(dataOrder.getTotal());
                return this.repository.save(dataOrder);
            } else {
                throw new Exception("orden no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteOrder(Integer id) throws Exception {
        try {
            Optional<Order> searchOrder = this.repository.findById(id);
            if (searchOrder.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("orden no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }











































}

