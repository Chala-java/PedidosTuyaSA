package com.example.PedidosAPP.controllers;


import com.example.PedidosAPP.models.Address;
import com.example.PedidosAPP.servicios.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class controllerAddress {

    @Autowired
    AddressServices addressServices;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Address requestData) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.addressServices.saveAddress(requestData));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> searchAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.addressServices.searchAllAddress());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


    @GetMapping("/id")
    public ResponseEntity<?> searchById(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.addressServices.searchAddressById(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Address data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.addressServices.modifyAddress(id, data));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.addressServices.deleteAddress(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
