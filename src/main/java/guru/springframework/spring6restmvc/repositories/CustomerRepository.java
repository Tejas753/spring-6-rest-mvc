package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author : tejas
 * @created : 4/11/23, Tuesday
 **/
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
