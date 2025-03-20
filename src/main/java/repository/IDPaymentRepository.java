package repository;

import com.example.PedidosAPP.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDPaymentRepository extends JpaRepository <Payment,Integer> {
}
