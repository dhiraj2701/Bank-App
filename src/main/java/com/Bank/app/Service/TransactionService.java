package com.Bank.app.Service;


import com.Bank.app.dao.*;
import lombok.SneakyThrows;
import com.Bank.app.Entity.TblUser;
import com.Bank.app.model.Transactions;
import com.Bank.app.Response.PageResponse;
import org.springframework.http.HttpStatus;
import com.Bank.app.Entity.TblTransactions;
import org.springframework.stereotype.Service;
import com.Bank.app.model.TransactionResponse;
import org.springframework.http.ResponseEntity;
import com.Bank.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.math.BigInteger;

import static com.Bank.app.Utils.CommonUtils.paginationCheck;
import static com.Bank.app.Utils.BuilderUtil.buildPageResponseFromBuilder;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private DebitRepository debitRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    TransRepo transRepo;

    @Override
    @SneakyThrows
    public ResponseEntity<?> getAllTransaction(Transactions transactions, BigInteger admin, BigInteger user) {
        BigInteger desUserId = admin != null ? admin : user;

        paginationCheck(transactions.getPageNo(), transactions.getPageSize());

        TblUser tblUser1 = userRepo.findById(desUserId)
                .orElseThrow(() -> new NotFoundException("User not found"));
        List<TransactionResponse> transactionResponseList = null;
        if (tblUser1.isAdminUser()) {
            transactionResponseList = transRepo.findTransactionById(transactions);
        } else {
            return new ResponseEntity<>("You don't have access", HttpStatus.OK);
        }

        PageResponse response = buildPageResponseFromBuilder(transactionResponseList
                , transactions.getPageNo()
                , transactions.getPageSize());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteTransactionById(BigInteger id, BigInteger userId) {
        TblTransactions tblTransactions = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Data not Found"));
        TblUser user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));
        if (user.isAdminUser()) {
            transactionRepository.delete(tblTransactions);
        } else {
            return new ResponseEntity<>("You Don't have access to Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
