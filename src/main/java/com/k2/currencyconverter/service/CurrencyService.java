package com.k2.currencyconverter.service;

import com.k2.currencyconverter.dao.CurrencyDao;
import com.k2.currencyconverter.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private  final CurrencyDao currencyDao ;

    @Autowired
    public CurrencyService(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }
    public  void  save(Currency currency){
        currencyDao.save(currency);
    }

    public  List<Currency>getAll(){
        return  currencyDao.findAll();
    }
}
