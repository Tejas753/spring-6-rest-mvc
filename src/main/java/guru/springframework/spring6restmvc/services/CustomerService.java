package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerCustomer;

import java.util.List;
import java.util.UUID;

/**
 * @author : tejas
 * @created : 3/24/23, Friday
 **/

public interface CustomerService {

    BeerCustomer saveNewCustomer(BeerCustomer customer) ;

    List<BeerCustomer> customerList();

    BeerCustomer getCustomerByID(UUID id);

    void updateByCustomerId(UUID customerId, BeerCustomer customer);

    void deleteByCustomerId(UUID customerId);

    void patchByCustomerId(UUID customerId, BeerCustomer customer);
}
