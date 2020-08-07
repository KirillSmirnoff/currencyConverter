package com.k2.currencyconverter.service;

import com.k2.currencyconverter.dao.ExchangeDao;
import com.k2.currencyconverter.domain.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Exchange> getAll(){
         return exchangeDao.findAll();
    }
}
