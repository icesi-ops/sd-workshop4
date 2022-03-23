package com.aforo.service;

import com.aforo.dao.TransactionDao;
import com.aforo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cloud.config.server.EnableConfigServer;


import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionDao _dao;

    public List<Transaction> findAllTransaction() {
        return _dao.findAll();
    }
}
