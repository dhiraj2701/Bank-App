package com.Bank.app.Service;


import com.Bank.app.dao.*;
import lombok.SneakyThrows;
import com.Bank.app.Entity.TblUser;
import com.Bank.app.model.Transactions;
import com.Bank.app.Response.PageResponse;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> getAllTransaction(Transactions transactions, BigInteger userId) {
        paginationCheck(transactions.getPageNo(), transactions.getPageSize());

        TblUser user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        List<TransactionResponse> transactionResponseList = transRepo.findTransactionById(transactions);

        PageResponse response = buildPageResponseFromBuilder(transactionResponseList
                , transactions.getPageNo()
                , transactions.getPageSize());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
