package com.Bank.app.Service;

import com.Bank.app.model.Debit;
import org.springframework.http.ResponseEntity;

public interface IDebitService {
    ResponseEntity<?> createDebit(Debit debit);
}
