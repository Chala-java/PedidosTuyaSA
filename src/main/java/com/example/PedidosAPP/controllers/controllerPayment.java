package com.example.PedidosAPP.controllers;

import com.example.PedidosAPP.models.Payment;
import com.example.PedidosAPP.servicios.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class controllerPayment {

    @Autowired
    PaymentServices paymentServices;

    @PostMapping
    public ResponseEntity <?> save(@RequestBody Payment requestData){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.paymentServices.savePayment(requestData));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity <?> searchAll(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.paymentServices.searchAllPayment());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/id")
    public ResponseEntity <?> searchById(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.paymentServices.searchAllPaymentById(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <?> modify(@PathVariable Integer id, @RequestBody Payment data){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.paymentServices.modifyPayment(id, data));
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
                    .body(this.paymentServices.deletePayment(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }






















































}
