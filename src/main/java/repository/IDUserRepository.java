package repository;

import com.example.PedidosAPP.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDUserRepository extends JpaRepository <Address,Integer> {


}
