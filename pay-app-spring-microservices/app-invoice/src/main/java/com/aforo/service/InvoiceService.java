package com.aforo.service;

import com.aforo.dao.InvoiceDao;
import com.aforo.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceDao _dao;

    public List<Invoice> findAllInvoices() {
        return _dao.findAllInvoices();
    }

    public Invoice findInvoiceById(Integer id) {
        Optional<Invoice> invoice = _dao.findById(id);
        if (invoice.isPresent()) {
            return invoice.get();
        }
        return null;
    }
}
