package com.Bank.app.Entity;

import lombok.Data;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_account", schema = "public")
public class TblAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger accountNo;
    private Date openingDate;
    private BigDecimal amount;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblAccount", orphanRemoval = true)
    @JsonIgnore
    private TblCustomer tblCustomer;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblAccount", orphanRemoval = true)
    @JsonIgnore
    private TblDebit tblDebit;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblAccount", orphanRemoval = true)
    @JsonIgnore
    private TblCredit tblCredit;
}
