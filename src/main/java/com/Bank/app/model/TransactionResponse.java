package com.Bank.app.model;

import com.Bank.app.Entity.TblCredit;
import com.Bank.app.Entity.TblDebit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private BigInteger id;
    private BigDecimal amount;
    private String type;
    private BigInteger accountNo;

}
