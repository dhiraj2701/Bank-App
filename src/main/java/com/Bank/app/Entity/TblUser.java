package com.Bank.app.Entity;

import lombok.Data;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user", schema = "public")
public class TblUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String userName;
    private String fullName;
    private boolean isAdminUser;
    private boolean isGroupUser;

}
