package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author : tejas
 * @created : 3/24/23, Friday
 **/
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, BeerCustomer> customerMap;

    public CustomerServiceImpl(){
        this.customerMap = new HashMap<>();

        BeerCustomer customer1 = BeerCustomer.builder()
                .id(UUID.randomUUID())
                .customerName("Micheal")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        BeerCustomer customer2 = BeerCustomer.builder()
                .id(UUID.randomUUID())
                .customerName("John")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        BeerCustomer customer3 = BeerCustomer.builder()
                .id(UUID.randomUUID())
                .customerName("Corner")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public BeerCustomer saveNewCustomer(BeerCustomer customer) {
        BeerCustomer savedCustomer = BeerCustomer.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .customerName(customer.getCustomerName())
                .version(customer.getVersion())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public List<BeerCustomer> customerList(){
        return new ArrayList<>(customerMap.values());
    }


    @Override
    public Optional<BeerCustomer> getCustomerByID(UUID id) {
        return Optional.of(customerMap.get(id));
    }

    @Override
    public void updateByCustomerId(UUID customerId, BeerCustomer customer) {
        BeerCustomer existing = customerMap.get(customerId);
        existing.setCustomerName(customer.getCustomerName());
        existing.setVersion(customer.getVersion());

        customerMap.put(existing.getId(), existing);
    }

    @Override
    public void deleteByCustomerId(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchByCustomerId(UUID customerId, BeerCustomer customer) {

        BeerCustomer existing = customerMap.get(customerId);

        if(StringUtils.hasText(customer.getCustomerName())){
            existing.setCustomerName(customer.getCustomerName());
        }
    }
}
