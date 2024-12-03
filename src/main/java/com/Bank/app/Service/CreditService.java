package com.Bank.app.Service;

import com.Bank.app.model.Credit;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
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

    @Override
    public ResponseEntity<?> createCredit(Credit credit) {
        TblAccount tblAccount = accountRepository.findByAccountNo(credit.getAccountNo());
        BigDecimal totalAmount = tblAccount.getAmount().add(credit.getCreditAmount());
        BigDecimal creditLimit= new BigDecimal("10000");
        if(credit.getCreditAmount().compareTo(creditLimit)>0){
            return new ResponseEntity<>("Credit amount exceeds the limit", HttpStatus.OK);
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
}
