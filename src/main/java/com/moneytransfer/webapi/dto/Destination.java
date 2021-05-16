package com.moneytransfer.webapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Destination {

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("currency")
    private String currency;

    public Destination() {
    }

    public Destination(String amount, String currency) {
        this.amount = amount;
        this.currency = currency;
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
}
