package com.Bank.app.mapper;

import com.Bank.app.model.TransactionResponse;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<TransactionResponse> {
    @Override
    public TransactionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        TransactionResponse transactionResponse = new TransactionResponse();

        transactionResponse.setId(BigInteger.valueOf(rs.getInt("id")));
        transactionResponse.setAmount(BigDecimal.valueOf(rs.getInt("amount")));
        transactionResponse.setType(rs.getString("type"));
        transactionResponse.setAccountNo(BigInteger.valueOf(rs.getLong("account_no")));
        return transactionResponse;
    }
}
