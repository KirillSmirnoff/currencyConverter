package com.k2.currencyconverter.xml;

import com.k2.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.time.LocalDate;

@Component
public class XmlParser {
    public static final String URi = "/home/k2/Desktop/XML_daily.xml";
    //    public static final String URi= "http://www.cbr.ru/scripts/XML_daily.asp";

    private static XMLHandler xmlHandler;
    private static CurrencyService currencyService;

    @Autowired
    public void setXmlHandler(XMLHandler xmlHandler, CurrencyService currencyService) {
        XmlParser.xmlHandler = xmlHandler;
        XmlParser.currencyService = currencyService;
    }

    public static void parseXml() {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse(URi, xmlHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkCourse(){
        currencyService.checkDate(LocalDate.now().toString());
    }
}