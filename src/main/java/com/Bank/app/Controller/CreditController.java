package com.Bank.app.Controller;

import com.Bank.app.model.Credit;
import com.Bank.app.Service.ICreditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit")
public class CreditController {
    @Autowired
    private ICreditService iCreditService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createCredit(@RequestBody Credit credit) {
        return iCreditService.createCredit(credit);
    }
}
