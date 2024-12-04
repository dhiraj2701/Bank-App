package com.Bank.app.Service;

import com.Bank.app.model.Account;
import com.Bank.app.Entity.TblAccount;
import com.Bank.app.dao.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public ResponseEntity<?> updateCustomer(Account account) {
        TblAccount tblAccount = accountRepository.findById(account.getId()).orElseThrow();
        tblAccount.setAccountNo(account.getAccountNo());
        tblAccount.setOpeningDate(account.getOpeningDate());
        tblAccount.setAmount(account.getAmount());
        accountRepository.save(tblAccount);
        return new ResponseEntity<>(tblAccount, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllAccount() {
        List<TblAccount> tblAccountList = accountRepository.findAll();
        return new ResponseEntity<>(tblAccountList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getByAccountId(BigInteger id) {
        TblAccount tblAccount = accountRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(tblAccount, HttpStatus.OK);
    }
}
