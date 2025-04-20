package com.example.PedidosAPP.controllers;


import com.example.PedidosAPP.models.Dealer;
import com.example.PedidosAPP.servicios.DealerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dealer")
public class controllerDealer {

    @Autowired
    DealerServices dealerServices;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Dealer requestData){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.dealerServices.saveDealer(requestData));
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
                    .body(this.dealerServices.searchAllDealer());
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
                    .body(this.dealerServices.searchDealerById(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Dealer data){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.dealerServices.modifyDealer(id, data));
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
                    .body(this.dealerServices.deleteDealer(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
