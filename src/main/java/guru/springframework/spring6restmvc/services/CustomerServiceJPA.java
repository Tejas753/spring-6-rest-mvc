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
import java.util.stream.Collectors;

/**
 * @author : tejas
 * @created : 4/12/23, Wednesday
 **/
@Service
@Primary
@RequiredArgsConstructor

public class CustomerServiceJPA implements CustomerService{
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public List<CustomerDTO> customerList() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerByID(UUID id) {
        return Optional.ofNullable(customerMapper.customerToCustomerDto(customerRepository.findById(id)
                .orElse(null)));
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
