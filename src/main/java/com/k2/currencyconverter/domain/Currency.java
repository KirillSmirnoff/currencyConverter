package com.k2.currencyconverter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "currencies")
public class Currency {

        @Id
        private  String id;

        @Column(name ="num_code")
        private String numCode;

        @Column(name = "char_code")
        private String charCode;

        @Column(name = "name")
        private String name;

        @Column(name = "value")
        double  value;

        @Column(name = "nominal")
        private int nominal =1;

        private Date date = null;

    public Currency(){
    }

    public Currency(String id, String numCode, String charCode, String name, double value, int nominal, Date date) {
            this.id = id;
            this.numCode = numCode;
            this.charCode = charCode;
            this.name = name;
            this.value = value;
            this.nominal= nominal;
            this.date = date;
        }

        public String getId() {
            return id;
        }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}