package com.k2.currencyconverter.dao;

import com.k2.currencyconverter.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyDao extends JpaRepository<Currency, String> {
}
