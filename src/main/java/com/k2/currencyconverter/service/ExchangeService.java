package com.k2.currencyconverter.service;

import com.k2.currencyconverter.dao.ExchangeDao;
import com.k2.currencyconverter.domain.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    private final ExchangeDao exchangeDao;

    @Autowired
    public ExchangeService(ExchangeDao exchangeDao) {
        this.exchangeDao = exchangeDao;
    }

    public void saveExchange(Exchange exchange){
        exchangeDao.save(exchange);
    }
}
