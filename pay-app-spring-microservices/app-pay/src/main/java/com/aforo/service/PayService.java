package com.aforo.service;

import com.aforo.dao.PayDao;
import com.aforo.model.Pay;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class PayService {

    private final String INVOICE_URL = "http://app-invoice:8006/";

    @Autowired
    private PayDao _dao;

    private RestTemplate _restTemplate;

    private final Logger log = LoggerFactory.getLogger(PayService.class);

    @Autowired
    public PayService(RestTemplate restTemplate) {
        _restTemplate = restTemplate;
    }

    public Pay registerPay(Pay pay) {
        int invoiceId = pay.getIdInvoice();
        double payAmount = pay.getAmount();
        String invoice = getInvoice(invoiceId);
        if (invoice == null) {
            throw new RuntimeException("No se pudo obtener la factura con id: " + invoiceId + " para el pago.");
        } else {
            log.info("Pay Service invoice: " + invoice);
            JSONObject invoiceJsonObject = new JSONObject(invoice);
            double invoiceAmount = invoiceJsonObject.getDouble("amount");
            if (payAmount > invoiceAmount) {
                throw new RuntimeException("El monto del pago no puede ser mayor al monto de la factura.");
            }
        }
        return _dao.save(pay);
    }

    private String getInvoice(Integer id) {
        String url = INVOICE_URL + id;
        ResponseEntity<String> responseEntity = _restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }
}
