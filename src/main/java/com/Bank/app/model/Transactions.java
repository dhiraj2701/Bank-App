package com.Bank.app.model;

import com.Bank.app.Entity.TblDebit;
import com.Bank.app.Entity.TblCredit;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
    private BigDecimal amount;
    private BigInteger userId;
    private String type;
    private LocalDateTime transactionDate;
    private BigInteger creditId;
    private TblDebit debited;
    private TblCredit credited;
    private Integer pageNo=0;
    private Integer pageSize=10;
    private void setPageNo(Integer pageNo){this.pageNo=pageNo;}
    private void setPageSize(Integer pageSize){this.pageSize=pageSize;}
}
