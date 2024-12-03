package com.Bank.app.dao;

import com.Bank.app.Entity.TblDebit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface DebitRepository extends JpaRepository<TblDebit, BigInteger> {
}
