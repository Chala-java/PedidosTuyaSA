package repository;

import com.example.PedidosAPP.models.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDDealerRepository extends JpaRepository <Dealer, Integer> {
}
