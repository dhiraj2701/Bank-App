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
public class Credit {
    private BigInteger id;
    private BigInteger accountNo;
    private BigDecimal creditAmount;
    private LocalDateTime creditDate;
    private TblAccount tblAccount;

}
