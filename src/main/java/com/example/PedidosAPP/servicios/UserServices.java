package com.example.PedidosAPP.servicios;


import com.example.PedidosAPP.models.User;
import com.example.PedidosAPP.repository.IDUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    IDUserRepository repository;

    // Método para guardar
    public User saveUser(User dataUser) throws Exception {
        try {
            // Validar los datos de entrada
            return this.repository.save(dataUser);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para buscar todos los registros
    //se llaman todos los registro con una lista
    public List<User> searchAllUser() throws Exception {
        try {
            return this.repository.findAll();  // Asegúrate de devolver el resultado
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para buscar por ID
    public User searchUserbyId(Integer idUser) throws Exception {
        try {
            Optional<User> searchUser = this.repository.findById(idUser);
            if (searchUser.isPresent()) {
                return searchUser.get();
            } else {
                throw new Exception("El usuario consultado no está en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para modificar por ID
    public User modificarUsuario(Integer id, User datosUsuario) throws Exception {
        try {
            Optional<User> usuarioBuscado = this.repository.findById(id);
            if (usuarioBuscado.isPresent()) {
                usuarioBuscado.get().setPhoneNumber(datosUsuario.getPhoneNumber());
                usuarioBuscado.get().setEmail(datosUsuario.getEmail());
                return this.repository.save(usuarioBuscado.get());
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para eliminar por ID
    //si el usuario es encontrado y esta presente se llama
    //el delete cuando sucede si pasa estos parametros se retorna un true
    // sino dice que no na sido encontrado
    public boolean eliminarUsuario(Integer id) throws Exception {
        try {
            Optional<User> usuarioBuscado = this.repository.findById(id);
            if (usuarioBuscado.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
