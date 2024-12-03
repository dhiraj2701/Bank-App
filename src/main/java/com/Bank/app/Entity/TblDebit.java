package com.Bank.app.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.math.BigInteger;

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

    @OneToOne
    @JoinColumn(name = "id",insertable = false,updatable = false)
    @JsonIgnore
    private TblAccount tblAccount;

    @JsonIgnore
    @OneToOne(mappedBy ="Debited")
    private TblTransactions tblTransactions;
}
