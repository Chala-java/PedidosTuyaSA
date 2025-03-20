package repository;

import com.example.PedidosAPP.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDDeliveryRepository extends JpaRepository <Delivery,Integer> {
}
