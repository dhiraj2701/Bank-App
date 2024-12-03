package com.Bank.app.dao;

import com.Bank.app.Entity.TblAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AccountRepository extends JpaRepository<TblAccount, BigInteger> {
    TblAccount findByAccountNo(BigInteger accountNo);
}
