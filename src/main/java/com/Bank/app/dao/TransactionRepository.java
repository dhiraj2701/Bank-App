package com.Bank.app.dao;

import com.Bank.app.Entity.TblTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TransactionRepository extends JpaRepository<TblTransactions, BigInteger> {
}
