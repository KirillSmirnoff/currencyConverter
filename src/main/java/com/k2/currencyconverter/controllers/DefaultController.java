package com.k2.currencyconverter.controllers;

import com.k2.currencyconverter.domain.Currency;
import com.k2.currencyconverter.service.CurrencyService;
import com.k2.currencyconverter.xml.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DefaultController {

    private final XmlParser xmlParser;
    private CurrencyService currencyService;

    @Autowired
    public DefaultController(XmlParser xmlParser, CurrencyService currencyService) {
        this.xmlParser = xmlParser;
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String start(Model modelUi) {
//        xmlParser.parseXml();
        List<Currency> currencies = currencyService.getAll();
        modelUi.addAttribute("currencies", currencies);
        return "index";
    }
}
