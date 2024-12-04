package com.Bank.app.dao;

import com.Bank.app.Entity.TblCredit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CreditRepository extends JpaRepository<TblCredit, BigInteger> {
}
