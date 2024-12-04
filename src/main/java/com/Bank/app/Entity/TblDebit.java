package com.Bank.app.Entity;

import lombok.Data;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_debit", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TblDebit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger accountNo;
    private BigDecimal debitAmount;
    private LocalDateTime debitDate;

    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @JsonIgnore
    private TblAccount tblAccount;

    @JsonIgnore
    @OneToOne(mappedBy = "Debited", cascade = CascadeType.ALL)
    private TblTransactions tblTransactions;
}
