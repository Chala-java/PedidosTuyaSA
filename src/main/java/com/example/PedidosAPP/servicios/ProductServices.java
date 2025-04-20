package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.models.Product;
import com.example.PedidosAPP.models.Store;
import com.example.PedidosAPP.models.User;
import com.example.PedidosAPP.repository.IDProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    IDProductRepository repository;

    public Product saveProduct(Product dataProduct) throws Exception{
        try {
            return this.repository.save(dataProduct);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Product> searchAllProduct() throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public Product searchAllProductById(Integer idProduct) throws Exception{
        try {
            Optional <Product> searchProduct = this.repository.findById(idProduct);
            if (searchProduct.isPresent()){
                return searchProduct.get();
            }else {
                throw new Exception("producto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Product modifyProduct(Integer idProduct, Product dataProduct) throws Exception{
        try {
            Optional <Product> searchProduct = this.repository.findById(idProduct);
            if (searchProduct.isPresent()){
                searchProduct.get().setPrice(dataProduct.getPrice());
                searchProduct.get().setDescription(dataProduct.getDescription());
                return this.repository.save(dataProduct);
            }else {
                throw new Exception("producto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


   public boolean deleteProduct (Integer id) throws Exception{
        try {
            Optional<Product> searchProduct = this.repository.findById(id);
            if (searchProduct.isPresent()){
                this.repository.deleteById(id);
              return true;
            }else {
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }



















































}
