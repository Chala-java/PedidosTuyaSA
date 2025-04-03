package com.example.PedidosAPP.controllers;

import com.example.PedidosAPP.models.User;
import com.example.PedidosAPP.servicios.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class controllerUser {

    //se inyecta una depedencia para llamar el servicio de usuario
    @Autowired
    UserServices userService;

    //Guardar
    //instancias
    @PostMapping
    public ResponseEntity<?>save(@RequestBody User requestData) {
        //(dejar la variable fuera del operador diamante cuando es tipo lista se usa lista,
        //entonces cuando no se sabe qué respuesta da se usa, él (?) Significa cualquier cosa trabajar DTO
        //para entender como utilizar el operador diamante)
        //Se llama una instancia request body se llama el modelo y se le da un nombre
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.userService.saveUser(requestData));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());

        }
    }
        //Buscar todos
        @GetMapping
        public ResponseEntity<?> searchAll () {
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.userService.searchAllUser());
            } catch (Exception error) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
            }
        }
    }
    //Buscar por id

    //HttpStatus.Ok cuando busca
    // HttpStatus.Created cuando guardar
    @GetMapping("/id")
    public ResponseEntity <?> searchByID(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.use
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).
                    body(error.getMessage());
        }
    }

    //Modificar
    //No existe el update solo el put
    @PutMapping ("/{id}")
    public ResponseEntity<?> modify (@PathVariable Integer id, @RequestBody User data){
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.userService.modificarUsuario(id,data));
            }catch (Exception error){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());
            }
        }
    }
    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.userService.eliminarUsuario(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


}
