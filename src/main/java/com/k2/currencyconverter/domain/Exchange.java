package com.k2.currencyconverter.domain;

import javax.persistence.*;

@Entity
@Table(name = "exchanges")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_id")
    private String currencyId;

    @Column(name = "original_currency")
    private String originalCurrencyName;

    @Column(name = "final_currency")
    private String finalCurrencyName;

    private int nominal;
    private double summary;
    private long time;

    public Exchange() {
    }

    public Exchange(String currencyId, String currencyName, String finalCurrency, int nominal, double summary, long time) {
        this.currencyId = currencyId;
        this.originalCurrencyName = currencyName;
        this.finalCurrencyName = finalCurrency;
        this.nominal = nominal;
        this.summary = summary;
        this.time = time;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getOriginalCurrencyName() {
        return originalCurrencyName;
    }

    public void setOriginalCurrencyName(String originalCurrency) {
        this.originalCurrencyName = originalCurrency;
    }

    public String getFinalCurrencyName() {
        return finalCurrencyName;
    }

    public void setFinalCurrencyName(String finalCurrency) {
        this.finalCurrencyName = finalCurrency;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public double getSummary() {
        return summary;
    }

    public void setSummary(double summary) {
        this.summary = summary;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
