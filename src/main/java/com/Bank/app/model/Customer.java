package com.Bank.app.model;

import com.Bank.app.Entity.TblAccount;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private BigInteger id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private TblAccount tblAccount;

}
