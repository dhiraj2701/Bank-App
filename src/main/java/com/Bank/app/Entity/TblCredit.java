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
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_credit", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TblCredit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger accountNo;
    private BigDecimal creditAmount;
    private LocalDateTime creditDate;

    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @JsonIgnore
    private TblAccount tblAccount;

    @JsonIgnore
    @OneToOne(mappedBy = "Credited")
    private TblTransactions tblTransactions;
}
