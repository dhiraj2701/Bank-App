package com.Bank.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.Bank.app.Entity.TblAccount;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Debit {
    private BigInteger id;
    private BigInteger accountNo;
    private BigDecimal debitAmount;
    private TblAccount tblAccount;
    private LocalDateTime debitDate;

}
