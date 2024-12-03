package com.Bank.app.dao;

import com.Bank.app.Entity.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepo extends JpaRepository<TblUser, BigInteger> {
    TblUser findByUserName(String userName);
}
