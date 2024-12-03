package com.Bank.app.Service;

import com.Bank.app.model.Credit;
import org.springframework.http.ResponseEntity;

public interface ICreditService {
    ResponseEntity<?> createCredit(Credit credit);
}
