package com.k2.currencyconverter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
        private String value;

    public Currency() {
    }

    public Currency(String id, String numCode, String charCode, String name, String value) {
            this.id = id;
            this.numCode = numCode;
            this.charCode = charCode;
            this.name = name;
            this.value = value;
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

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }