package com.k2.currencyconverter.dao;

import com.k2.currencyconverter.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurrencyDao extends JpaRepository<Currency, String> {

    @Query(value = "select c from Currency c where c.date = ?1 limit 1"  )
    public List<Currency> checkDate(String date);
}
