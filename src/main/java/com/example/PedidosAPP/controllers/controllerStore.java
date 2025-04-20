package com.example.PedidosAPP.controllers;

import com.example.PedidosAPP.models.Store;
import com.example.PedidosAPP.repository.IDStoreRepository;
import com.example.PedidosAPP.servicios.StoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class controllerStore {

    @Autowired
    StoreServices storeServices;

   @PostMapping

    public ResponseEntity <?> save(@RequestBody  Store requestData ) {
       try {
           return ResponseEntity.status(HttpStatus.CREATED)
                   .body(this.storeServices.saveStore(requestData));

       } catch (Exception error) {
         return ResponseEntity
                 .status(HttpStatus.BAD_REQUEST)
                 .body(error.getMessage());
       }
   }

   @GetMapping

    public ResponseEntity <?> seachAll (){
       try {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(this.storeServices.searchAllStore());
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
                  .body(this.storeServices.searchAllStoreById(id));
      }catch (Exception error){
          return ResponseEntity
                  .status(HttpStatus.BAD_REQUEST)
                  .body(error.getMessage());
      }
   }

   @PutMapping("/{id}")
    public ResponseEntity<?> modify (@PathVariable Integer id, @RequestBody Store data){
       try {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(this.storeServices.modifyStore(id, data));
       }catch (Exception error){
           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body(error.getMessage());
       }
   }

   @DeleteMapping("/{id}")
    public ResponseEntity <?> delete (@PathVariable Integer id){
       try {
           return  ResponseEntity
                   .status(HttpStatus.OK)
                   .body(this.storeServices.deleteStore(id));
       }catch (Exception error){
           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body(error.getMessage());
       }
   }

}
