package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.entities.Customer;
import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.UUID;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author : tejas
 * @created : 4/12/23, Wednesday
 **/
@SpringBootTest
class CustomerControllerIntegrationTest {

    @Autowired
    CustomerController customerController;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testCustomerIdNotFound() {
        assertThrows(NotFoundException.class, () ->{
           customerController.getCustomerByID(UUID.randomUUID());
        });
    }

    @Test
    void testGetById(){
        Customer customer = customerRepository.findAll().get(0);

        CustomerDTO dto = customerController.getCustomerByID(customer.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testListCustomers() {
        List<CustomerDTO> dtos = customerController.customerList();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Rollback
    @Transactional
    @Test
    void testEmptyList() {
        customerRepository.deleteAll();
        List<CustomerDTO> dtos = customerController.customerList();

        assertThat(dtos.size()).isEqualTo(0);
    }
}