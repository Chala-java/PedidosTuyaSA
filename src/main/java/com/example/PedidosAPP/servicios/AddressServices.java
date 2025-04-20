package com.example.PedidosAPP.servicios;

import com.example.PedidosAPP.models.Address;
import com.example.PedidosAPP.repository.IDAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServices {
    @Autowired
    IDAddressRepository repository;

    public Address saveAddress(Address dataAddress) throws Exception{
        try {
          return this.repository.save(dataAddress);
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    public List<Address> searchAllAddress() throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Address searchAddressById(Integer idAddress) throws Exception{
        try {
            Optional<Address> searchAddress = this.repository.findById(idAddress);
            if (searchAddress.isPresent()){
                return searchAddress.get();
            }else throw new Exception("direccion no encontrada");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Address modifyAddress(Integer idAddress, Address dataAddress) throws Exception{
        try {
            Optional<Address> searchAddress = this.repository.findById(idAddress);
            if (searchAddress.isPresent()){
                searchAddress.get().setCity(dataAddress.getCity());
                searchAddress.get().setCountry(dataAddress.getCountry());
                searchAddress.get().setPostcode(dataAddress.getPostcode());
                searchAddress.get().setStreet(dataAddress.getStreet());
                return this.repository.save(dataAddress);
            }else{
                throw new Exception("Direccion no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteAddress(Integer id) throws Exception{
        try {
            Optional<Address> searchAddress = this.repository.findById(id);
            if (searchAddress.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else throw new Exception("Direccion no encontrada");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
