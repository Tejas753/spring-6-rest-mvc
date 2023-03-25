package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerCustomer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author : tejas
 * @created : 3/24/23, Friday
 **/
@Service
public interface CustomerService {

    List<BeerCustomer> customerList();

    BeerCustomer getCustomerByID(UUID id);
}
