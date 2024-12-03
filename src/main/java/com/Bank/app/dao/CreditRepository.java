package com.Bank.app.dao;

import com.Bank.app.Entity.TblCredit;
import com.Bank.app.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface CreditRepository extends JpaRepository<TblCredit, BigInteger> {
}
