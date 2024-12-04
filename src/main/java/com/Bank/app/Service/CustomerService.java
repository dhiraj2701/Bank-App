package com.Bank.app.Service;

import com.Bank.app.model.Customer;
import com.Bank.app.Entity.TblAccount;
import com.Bank.app.Entity.TblCustomer;
import com.Bank.app.dao.AccountRepository;
import com.Bank.app.dao.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.Bank.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public ResponseEntity<?> createCustomer(Customer customer) {
        TblAccount account = accountRepository.findByAccountNo(customer.getTblAccount().getAccountNo());
        if (account != null) {
            return new ResponseEntity<>("Account already exist", HttpStatus.OK);
        }
        TblAccount tblAccount = TblAccount.builder()
                .openingDate(customer.getTblAccount().getOpeningDate())
                .amount(customer.getTblAccount().getAmount())
                .accountNo(customer.getTblAccount().getAccountNo())
                .build();
        accountRepository.save(tblAccount);
        TblCustomer tblCustomer = TblCustomer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .tblAccount(tblAccount)
                .build();
        customerRepository.save(tblCustomer);
        return new ResponseEntity<>(tblCustomer, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getCustomerByID(BigInteger id) {
        Optional<TblCustomer> tblCustomer = customerRepository.findById(id);
        return new ResponseEntity<>(tblCustomer, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllCustomers() {
        List<TblCustomer> tblCustomers = customerRepository.findAll();
        return new ResponseEntity<>(tblCustomers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteCustomerById(BigInteger id) {
        TblCustomer tblCustomer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(tblCustomer);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateCustomerById(Customer customer) {
        TblCustomer tblCustomer = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new NotFoundException("data not found"));
        tblCustomer.setFirstName(customer.getFirstName());
        tblCustomer.setLastName(customer.getLastName());
        tblCustomer.setEmail(customer.getEmail());
        tblCustomer.setAddress(customer.getAddress());
        customerRepository.save(tblCustomer);
        return new ResponseEntity<>(tblCustomer, HttpStatus.OK);
    }

}
