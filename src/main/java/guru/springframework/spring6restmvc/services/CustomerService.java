package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author : tejas
 * @created : 3/24/23, Friday
 **/

public interface CustomerService {

    CustomerDTO saveNewCustomer(CustomerDTO customer) ;

    List<CustomerDTO> customerList();

    Optional<CustomerDTO> getCustomerByID(UUID id);

    void updateByCustomerId(UUID customerId, CustomerDTO customer);

    void deleteByCustomerId(UUID customerId);

    void patchByCustomerId(UUID customerId, CustomerDTO customer);
}
