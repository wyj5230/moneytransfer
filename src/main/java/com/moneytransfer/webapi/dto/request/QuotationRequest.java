package com.moneytransfer.webapi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moneytransfer.webapi.dto.Destination;
import com.moneytransfer.webapi.dto.Source;

public class QuotationRequest {

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("payer_id")
    private String payerId;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("transaction_type")
    private String transactionType;

    @JsonProperty("source")
    private Source source;

    @JsonProperty("destination")
    private Destination Destination;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public com.moneytransfer.webapi.dto.Destination getDestination() {
        return Destination;
    }

    public void setDestination(com.moneytransfer.webapi.dto.Destination destination) {
        Destination = destination;
    }
}
