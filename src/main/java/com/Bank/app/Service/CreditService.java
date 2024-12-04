package com.Bank.app.Service;

import com.Bank.app.dao.UserRepo;
import com.Bank.app.model.Credit;
import com.Bank.app.Entity.TblUser;
import com.Bank.app.Entity.TblCredit;
import com.Bank.app.Entity.TblAccount;
import jakarta.transaction.Transactional;
import com.Bank.app.dao.CreditRepository;
import com.Bank.app.dao.AccountRepository;
import org.springframework.http.HttpStatus;
import com.Bank.app.Entity.TblTransactions;
import com.Bank.app.dao.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.Bank.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Service
@Transactional
public class CreditService implements ICreditService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<?> createCredit(Credit credit) {
        TblAccount tblAccount = accountRepository.findByAccountNo(credit.getAccountNo());
        BigDecimal totalAmount = tblAccount.getAmount().add(credit.getCreditAmount());
        BigDecimal creditLimit = new BigDecimal("10000");
        BigDecimal creditLimit2 = new BigDecimal("0");
        if (credit.getCreditAmount().compareTo(creditLimit) > 0 || credit.getCreditAmount().compareTo(creditLimit2) < 0) {
            return new ResponseEntity<>("Credit amount can't be Zero or more than 10,000.00", HttpStatus.OK);
        }
        if (totalAmount.compareTo(BigDecimal.ZERO) < 0) {
            return new ResponseEntity<>("insufficient Amount", HttpStatus.OK);
        }
        tblAccount.setAmount(totalAmount);
        accountRepository.save(tblAccount);
        TblCredit Credited = TblCredit.builder()
                .accountNo(credit.getAccountNo())
                .creditAmount(credit.getCreditAmount())
                .creditDate(LocalDateTime.now())
                .tblAccount(tblAccount)
                .build();
        creditRepository.save(Credited);
        TblTransactions tblTransactions = TblTransactions.builder()
                .amount(credit.getCreditAmount())
                .type("Credit")
                .accountNo(credit.getAccountNo())
                .transactionDate(LocalDateTime.now())
                .Credited(Credited)
                .build();
        transactionRepository.save(tblTransactions);
        return new ResponseEntity<>(Credited, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteCreditById(BigInteger id, BigInteger userId) {
        TblCredit tblCredit = creditRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Data not Found"));
        TblUser user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));
        if (user.isAdminUser()) {
            creditRepository.delete(tblCredit);
        } else {
            return new ResponseEntity<>("You Don't have access to Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
