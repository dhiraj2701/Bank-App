package com.Bank.app.Service;

import com.Bank.app.model.Account;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public interface IAccountService {
    ResponseEntity<?> updateCustomer(Account account);

    ResponseEntity<?> getAllAccount();

    ResponseEntity<?> getByAccountId(BigInteger id);
}
