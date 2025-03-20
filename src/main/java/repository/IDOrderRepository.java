package repository;

import com.example.PedidosAPP.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDOrderRepository extends JpaRepository <Order,Integer> {
}
