package com.k2.currencyconverter.xml;

import com.k2.currencyconverter.domain.Currency;
import com.k2.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@Component
class XMLHandler extends DefaultHandler {
        private  String id;
        private String numCode;
        private String charCode;
        private String name;
        private String value;

        private static String currentElement = null;

        private   final CurrencyService currencyService;

        @Autowired
        public XMLHandler(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("Valute"))
                id=attributes.getValue("ID");
            else
                currentElement=qName;

        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String valueOfXML = new String(ch, start, length);

            if (currentElement.equals("NumCode"))
                numCode=valueOfXML;
            if (currentElement.equals("CharCode"))
                charCode=valueOfXML;
            if (currentElement.equals("Name"))
                name=valueOfXML;
            if (currentElement.equals("Value"))
                value = valueOfXML;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (value != null) {
                currencyService.save(new Currency(id, numCode, charCode, name, value));
            }
            value=null;
        }
    }