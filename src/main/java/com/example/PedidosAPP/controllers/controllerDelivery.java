package com.example.PedidosAPP.controllers;

import com.example.PedidosAPP.models.Delivery;
import com.example.PedidosAPP.servicios.DeliveryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivey")
public class controllerDelivery {

    @Autowired
    DeliveryServices deliveryServices;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Delivery requestData){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.deliveryServices.saveDelivery(requestData));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> searchAll(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.deliveryServices.searchAllDelivery());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> searchById (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.deliveryServices.searchDeliveryById(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("/{id}")

    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Delivery data){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.deliveryServices.modifyDelivery(id, data));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.deliveryServices.deleteDelivery(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
