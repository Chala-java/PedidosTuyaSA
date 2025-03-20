package repository;

import com.example.PedidosAPP.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDAddressRepository extends JpaRepository<User,Integer> {
    //ACA DENTRO DEL REPO VAN LAS CONSULTAS PERSONALIZADAS

}
