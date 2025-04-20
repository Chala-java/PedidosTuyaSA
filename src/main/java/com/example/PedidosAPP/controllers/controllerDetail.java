package com.example.PedidosAPP.controllers;

import com.example.PedidosAPP.models.Detail;
import com.example.PedidosAPP.servicios.DetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detail")
public class controllerDetail {
    @Autowired
    DetailServices detailServices;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Detail requestData){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.detailServices.saveDetail(requestData));
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
                    .body(this.detailServices.searchAllOrder());
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
                    .body(this.detailServices.searchOrderByID(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modify (@PathVariable Integer id, @RequestBody Detail data){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.detailServices.modifyDetail(id, data));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/{}")
    public ResponseEntity<?> delete (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.detailServices.deleteDetail(id));
        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
}
