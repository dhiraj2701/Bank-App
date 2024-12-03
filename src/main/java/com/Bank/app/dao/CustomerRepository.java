package com.Bank.app.dao;

import com.Bank.app.Entity.TblCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CustomerRepository extends JpaRepository<TblCustomer, BigInteger> {
    TblCustomer findByEmail(String email);
}
