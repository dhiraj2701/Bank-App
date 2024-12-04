package com.Bank.app.Entity;

import java.math.BigInteger;

import lombok.Data;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_customer", schema = "public")
public class TblCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acc_id", referencedColumnName = "id")
    private TblAccount tblAccount;
}
