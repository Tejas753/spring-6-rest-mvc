package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.mappers.CustomerMapper;
import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author : tejas
 * @created : 4/12/23, Wednesday
 **/
@Service
@RequiredArgsConstructor
@Primary
public class CustomerServiceJPA implements CustomerService{
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public List<CustomerDTO> customerList() {
        return null;
    }

    @Override
    public Optional<CustomerDTO> getCustomerByID(UUID id) {
        return Optional.empty();
    }

    @Override
    public void updateByCustomerId(UUID customerId, CustomerDTO customer) {

    }

    @Override
    public void deleteByCustomerId(UUID customerId) {

    }

    @Override
    public void patchByCustomerId(UUID customerId, CustomerDTO customer) {

    }
}
