package com.Bank.app.dao;

import com.Bank.app.model.Transactions;
import com.Bank.app.model.TransactionResponse;
import com.Bank.app.mapper.TransactionRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class TransRepo {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public TransRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TransactionResponse> findTransactionById(Transactions transactions) {
        StringBuilder query = new StringBuilder()
                .append("select t.id as id,t.account_no as account_no,t.amount as amount,t.type as type" +
                        " from public.tbl_transaction t ");
        return jdbcTemplate.query(query.toString(), new TransactionRowMapper());
    }
}
