package com.moneytransfer.webapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Source {

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("country_iso_code")
    private String countryIsoCode;

    public Source() {

    }

    public Source(String amount, String currency, String countryIsoCode) {
        this.amount = amount;
        this.currency = currency;
        this.countryIsoCode = countryIsoCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }
}
