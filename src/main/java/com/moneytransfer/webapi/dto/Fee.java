package com.moneytransfer.webapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fee {

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("currency")
    private String currency;

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

    @Override
    public String toString() {
        return "Fee{" +
                "amount:'" + amount + '\'' +
                ", currency:'" + currency + '\'' +
                '}';
    }
}
