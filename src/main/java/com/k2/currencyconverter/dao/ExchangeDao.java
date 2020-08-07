package com.k2.currencyconverter.dao;

import com.k2.currencyconverter.domain.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeDao extends JpaRepository<Exchange, Long> {
}
