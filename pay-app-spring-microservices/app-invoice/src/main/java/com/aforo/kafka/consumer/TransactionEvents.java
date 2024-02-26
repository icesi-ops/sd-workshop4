package com.aforo.kafka.consumer;

import com.aforo.dao.InvoiceDao;
import com.aforo.model.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionEvents {

    @Autowired
    private InvoiceDao _dao;

    @Autowired
    private ObjectMapper objectMapper;

    private Logger log = LoggerFactory.getLogger(TransactionEvents.class);

    public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        Invoice event = objectMapper.readValue(consumerRecord.value(), Invoice.class);
        log.info("Actualizando Invoice ***" + event.getIdInvoice());

        Optional<Invoice> optionalInvoice = _dao.findById(event.getIdInvoice());

        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();
            double newAmount = invoice.getAmount() - event.getAmount();
            invoice.setAmount(newAmount);
            invoice.setState(invoice.getAmount() == 0 ? 1 : 0);
            _dao.save(invoice);
            log.info("Se ha pagado la factura # " + event.getIdInvoice());
        } else {
            log.info("No se encontró la factura # " + event.getIdInvoice());
        }
    }
}
