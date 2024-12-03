package com.Bank.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private BigInteger id;
    private BigInteger accountNo;
    private Date openingDate;
    private BigDecimal amount;

}
