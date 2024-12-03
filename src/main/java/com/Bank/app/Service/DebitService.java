package com.Bank.app.Service;

import com.Bank.app.dao.TransRepo;
import com.Bank.app.model.Debit;
import com.Bank.app.Entity.TblDebit;
import com.Bank.app.Entity.TblAccount;
import com.Bank.app.dao.DebitRepository;
import jakarta.transaction.Transactional;
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
public class DebitService implements IDebitService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private DebitRepository debitRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransRepo transRepo;

    @Override
    @Transactional
    public ResponseEntity<?> createDebit(Debit debit) {
        TblAccount tblAccount = accountRepository.findByAccountNo(debit.getAccountNo());
        BigDecimal totalAmount = tblAccount.getAmount().subtract(debit.getDebitAmount());
        BigDecimal DebitLimit = new BigDecimal(10000);
        if (debit.getDebitAmount().compareTo(DebitLimit) > 0|| debit.getDebitAmount().compareTo(BigDecimal.ZERO)<0) {
            return new ResponseEntity<>("Debit amount can't be Zero or more than 10,000.00", HttpStatus.OK);
        }
        if (totalAmount.compareTo(BigDecimal.ZERO) < 0) {
            return new ResponseEntity<>("Insufficient Amount", HttpStatus.BAD_REQUEST);
        }
        tblAccount.setAmount(totalAmount);
        accountRepository.save(tblAccount);
        TblDebit tblDebit = TblDebit.builder()
                .accountNo(debit.getAccountNo())
                .debitAmount(debit.getDebitAmount())
                .tblAccount(tblAccount)
                .build();
        debitRepository.save(tblDebit);
        TblTransactions tblTransactions = TblTransactions.builder()
                .amount(debit.getDebitAmount())
                .type("Debit")
                .accountNo(debit.getAccountNo())
                .transactionDate(LocalDateTime.now())
                .Debited(tblDebit)
                .build();
        transactionRepository.save(tblTransactions);
        return new ResponseEntity<>(tblDebit, HttpStatus.OK);
    }
}
