package com.moneytransfer.webapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SentAmount {

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("currency")
    private String currency;

    public SentAmount() {

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
