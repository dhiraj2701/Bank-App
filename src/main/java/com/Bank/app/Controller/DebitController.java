package com.Bank.app.Controller;

import com.Bank.app.model.Debit;
import com.Bank.app.Service.IDebitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debit")
public class DebitController {
    @Autowired
    private IDebitService iDebitService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createDebit(@RequestBody Debit debit) {
        return iDebitService.createDebit(debit);
    }
}
