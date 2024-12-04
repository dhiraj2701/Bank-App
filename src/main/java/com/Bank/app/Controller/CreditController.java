package com.Bank.app.Controller;

import com.Bank.app.model.Credit;
import com.Bank.app.Service.ICreditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

@RestController
@RequestMapping("/credit")
public class CreditController {
    @Autowired
    private ICreditService iCreditService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createCredit(@RequestBody Credit credit) {
        return iCreditService.createCredit(credit);
    }

    @PostMapping(value = "delete")
    public ResponseEntity<?> deleteCreditById(@RequestParam(value = "id") BigInteger id,
                                              @RequestHeader("userId") BigInteger userId) {
        return iCreditService.deleteCreditById(id, userId);
    }
}
