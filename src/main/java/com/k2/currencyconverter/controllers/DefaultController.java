package com.k2.currencyconverter.controllers;

import com.k2.currencyconverter.domain.Currency;
import com.k2.currencyconverter.domain.Exchange;
import com.k2.currencyconverter.service.CurrencyService;
import com.k2.currencyconverter.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Controller
public class DefaultController {

    private final ExchangeService exchangeService;
    private final CurrencyService currencyService;
    private List<Currency> currencies;

    @Autowired
    public DefaultController(ExchangeService exchangeService, CurrencyService currencyService) {
        this.exchangeService = exchangeService;
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String start(Model modelUi) {

        modelUi.addAttribute("exchange",new Exchange());

        currencies = currencyService.getAll();
        modelUi.addAttribute("currencies", currencies);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String convert(@RequestParam("nominal") int nominal,
                          @RequestParam("currencyId") String currencyId,
                          @RequestParam("finalCurrencyName") String finalCurrencyName,
                          Model modelUi
                          ){
        Currency currency = currencyService.getCurrencyValueById(currencyId);

        double summary = nominal * currency.getValue();
//        double summary = nominal * currencyService.getCurrencyValueById(originalCurrency);
        Exchange exchange = new Exchange(currencyId,currency.getName(),finalCurrencyName, nominal, summary,
                Instant.now().plusMillis(10800000).toEpochMilli()/1000);

        modelUi.addAttribute("currencies", currencies);
        modelUi.addAttribute("exchange", exchange);

        exchangeService.saveExchange(exchange);

        return "index";
    }

}
