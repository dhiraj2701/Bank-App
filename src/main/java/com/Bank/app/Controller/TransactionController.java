package com.Bank.app.Controller;

import com.Bank.app.Service.ITransactionService;
import com.Bank.app.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService iTransactionService;

    @PostMapping("transaction-search")
    public ResponseEntity<?> getAllTransaction(@RequestBody Transactions transactions,
                                               @RequestHeader(value = "admin") BigInteger admin,
                                               @RequestParam(value = "user", required = false) BigInteger user) {
        return iTransactionService.getAllTransaction(transactions, admin, user);
    }

    @PostMapping(value = "delete")
    public ResponseEntity<?> deleteTransactionById(@RequestParam(value = "id") BigInteger id,
                                                   @RequestHeader("userId") BigInteger userId) {
        return iTransactionService.deleteTransactionById(id, userId);
    }
}
