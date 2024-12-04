package com.Bank.app.Service;

import com.Bank.app.model.Credit;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public interface ICreditService {
    ResponseEntity<?> createCredit(Credit credit);

    ResponseEntity<?> deleteCreditById(BigInteger id, BigInteger userId);
}
