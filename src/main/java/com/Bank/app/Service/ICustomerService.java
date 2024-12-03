package com.Bank.app.Service;

import com.Bank.app.model.Customer;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public interface ICustomerService {
    ResponseEntity<?> createCustomer(Customer customer);

    ResponseEntity<?> getCustomerByID(BigInteger id);

    ResponseEntity<?> getAllCustomers();

    ResponseEntity<?> deleteCustomerById(BigInteger id);
}
