package com.Bank.app.model;

import com.Bank.app.Entity.TblAccount;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Debit {
    private BigInteger id;
    private BigInteger accountNo;
    private BigDecimal debitAmount;
    private TblAccount tblAccount;
}
