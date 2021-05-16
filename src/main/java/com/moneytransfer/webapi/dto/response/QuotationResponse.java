package com.moneytransfer.webapi.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moneytransfer.webapi.dto.*;

public class QuotationResponse {

    @JsonProperty("creation_date")
    private String creationDate;

    @JsonProperty("destination")
    private Destination destination;

    @JsonProperty("expiration_date")
    private String expirationDate;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("fee")
    private Fee fee;

    @JsonProperty("id")
    private String id;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("payer")
    private Payer payer;

    @JsonProperty("sent_amount")
    private SentAmount sentAmount;

    @JsonProperty("source")
    private Source source;

    @JsonProperty("transaction_type")
    private String transactionType;

    @JsonProperty("wholesale_fx_rate")
    private String wholesaleFxRate;

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public SentAmount getSentAmount() {
        return sentAmount;
    }

    public void setSentAmount(SentAmount sentAmount) {
        this.sentAmount = sentAmount;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getWholesaleFxRate() {
        return wholesaleFxRate;
    }

    public void setWholesaleFxRate(String wholesaleFxRate) {
        this.wholesaleFxRate = wholesaleFxRate;
    }
}
