package com.example.PedidosAPP.controllers;

import com.example.PedidosAPP.models.Product;
import com.example.PedidosAPP.servicios.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class controllerProduct {

    @Autowired
    ProductServices productServices;

    @PostMapping
    public ResponseEntity <?> save (@RequestBody Product requestData){
        try {
          return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.productServices.saveProduct(requestData));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity <?> searchAll (){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productServices.searchAllProduct());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/id")
    public ResponseEntity <?> searchById (@PathVariable Integer id){
        try {
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productServices.searchAllProductById(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <?> modify (@PathVariable Integer id, @RequestBody Product data){
        try {
          return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productServices.modifyProduct(id, data));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productServices.deleteProduct(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
