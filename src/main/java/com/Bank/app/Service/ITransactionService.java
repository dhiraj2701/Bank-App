package com.Bank.app.Service;

import com.Bank.app.model.Transactions;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public interface ITransactionService {
    ResponseEntity<?> getAllTransaction(Transactions transactions, BigInteger admin, BigInteger user);

    ResponseEntity<?> deleteTransactionById(BigInteger id, BigInteger userId);

}
