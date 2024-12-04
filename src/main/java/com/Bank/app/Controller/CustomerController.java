package com.Bank.app.Controller;

import com.Bank.app.model.Customer;
import com.Bank.app.Service.ICustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        return iCustomerService.createCustomer(customer);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getCustomerByID(@PathVariable("id") BigInteger id) {
        return iCustomerService.getCustomerByID(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCustomers() {
        return iCustomerService.getAllCustomers();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable("id") BigInteger id) {
        return iCustomerService.deleteCustomerById(id);
    }

    @PostMapping("update")
    public ResponseEntity<?> updateCustomerById(@RequestBody Customer customer) {
        return iCustomerService.updateCustomerById(customer);
    }
}
