package com.k2.currencyconverter.xml;

import com.k2.currencyconverter.domain.Currency;
import com.k2.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
class XMLHandler extends DefaultHandler {
        private  String id;
        private String numCode;
        private String charCode;
        private String name;
        private double value;
        private int nominal;
        private Date date;

        private static String currentElement = null;

        private   final CurrencyService currencyService;

        @Autowired
        public XMLHandler(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    private static Date parseDate(String date)  {
        Date sqlDate =null;
        try {
            sqlDate = new Date( new SimpleDateFormat("dd.MM.yyyy")
                    .parse(date)
                    .getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sqlDate;
    }

    @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("ValCurs"))
            date = parseDate(attributes.getValue("Date"));
        else if (qName.equals("Valute"))
            id = attributes.getValue("ID");
        else
            currentElement = qName;

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
                value = Double.parseDouble(valueOfXML.replace(",","."));
            if (currentElement.equals("Nominal"))
                nominal = Integer.parseInt(valueOfXML);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (value != 0) {
                currencyService.save(new Currency(id, numCode, charCode, name, value, nominal,date));
            }
            value=0;
        }
    }