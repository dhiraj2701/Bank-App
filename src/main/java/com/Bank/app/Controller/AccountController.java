package com.Bank.app.Controller;

import com.Bank.app.model.Account;
import com.Bank.app.Service.IAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;

    @PostMapping(value = "update")
    public ResponseEntity<?> updateCustomer(@RequestBody Account account) {
        return iAccountService.updateCustomer(account);
    }

    @GetMapping("account-search")
    public ResponseEntity<?> getAllAccount() {
        return iAccountService.getAllAccount();
    }

    @GetMapping("account-by-id")
    public ResponseEntity<?> getByAccountId(@RequestHeader("id") BigInteger id) {
        return iAccountService.getByAccountId(id);
    }
}
