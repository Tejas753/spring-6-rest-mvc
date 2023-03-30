package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.BeerCustomer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author : tejas
 * @created : 3/24/23, Friday
 **/
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PatchMapping("{customerId}")
    public ResponseEntity patchById(@PathVariable("customerId")UUID customerId, @RequestBody BeerCustomer customer){

        customerService.patchByCustomerId(customerId, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteByID(@PathVariable("customerId")UUID customerId){

        customerService.deleteByCustomerId(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateById(@PathVariable("customerId")UUID customerId, @RequestBody BeerCustomer customer){

        customerService.updateByCustomerId(customerId, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerCustomer customer){
        BeerCustomer savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/v1/customer" + savedCustomer.getId().toString());

        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BeerCustomer> customerList(){
        return customerService.customerList();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public BeerCustomer getCustomerByID(@PathVariable("customerId") UUID customerId){
        return customerService.getCustomerByID(customerId);
    }

}
