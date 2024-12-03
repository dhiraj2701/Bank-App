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
                                               @RequestParam(value="userId") BigInteger id){
        return iTransactionService.getAllTransaction(transactions,id);
    }
}
