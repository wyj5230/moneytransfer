package com.moneytransfer.webapi.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moneytransfer.webapi.dto.*;

public class TransactionResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("status_message")
    private String statusMessage;

    @JsonProperty("status_class")
    private String statusClass;

    @JsonProperty("status_class_message")
    private String statusClassMessage;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("external_code")
    private String externalCode;

    @JsonProperty("transaction_type")
    private String transactionType;

    @JsonProperty("payer_transaction_reference")
    private String payerTransactionReference;

    @JsonProperty("payer_transaction_code")
    private String payerTransactionCode;

    @JsonProperty("creation_date")
    private String creationDate;

    @JsonProperty("expiration_date")
    private String expirationDate;

    @JsonProperty("credit_party_identifier")
    private CreditPartyIdentifier creditPartyIdentifier;

    @JsonProperty("source")
    private Source source;

    @JsonProperty("destination")
    private Destination destination;

    @JsonProperty("payer")
    private Payer payer;

    @JsonProperty("sender")
    private Sender sender;

    @JsonProperty("sent_amount")
    private SentAmount sentAmount;

    @JsonProperty("wholesale_fx_rate")
    private String wholesaleFxRate;

    @JsonProperty("retail_rate")
    private String retailRate;

    @JsonProperty("retail_fee")
    private String retailFee;

    @JsonProperty("retail_fee_currency")
    private String retailFeeCurrency;

    @JsonProperty("fee")
    private Fee fee;

    @JsonProperty("purpose_of_remittance")
    private String purposeOfRemittance;

    @JsonProperty("document_reference_number")
    private String documentReferenceNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusClass() {
        return statusClass;
    }

    public void setStatusClass(String statusClass) {
        this.statusClass = statusClass;
    }

    public String getStatusClassMessage() {
        return statusClassMessage;
    }

    public void setStatusClassMessage(String statusClassMessage) {
        this.statusClassMessage = statusClassMessage;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getPayerTransactionReference() {
        return payerTransactionReference;
    }

    public void setPayerTransactionReference(String payerTransactionReference) {
        this.payerTransactionReference = payerTransactionReference;
    }

    public String getPayerTransactionCode() {
        return payerTransactionCode;
    }

    public void setPayerTransactionCode(String payerTransactionCode) {
        this.payerTransactionCode = payerTransactionCode;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CreditPartyIdentifier getCreditPartyIdentifier() {
        return creditPartyIdentifier;
    }

    public void setCreditPartyIdentifier(CreditPartyIdentifier creditPartyIdentifier) {
        this.creditPartyIdentifier = creditPartyIdentifier;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public SentAmount getSentAmount() {
        return sentAmount;
    }

    public void setSentAmount(SentAmount sentAmount) {
        this.sentAmount = sentAmount;
    }

    public String getWholesaleFxRate() {
        return wholesaleFxRate;
    }

    public void setWholesaleFxRate(String wholesaleFxRate) {
        this.wholesaleFxRate = wholesaleFxRate;
    }

    public String getRetailRate() {
        return retailRate;
    }

    public void setRetailRate(String retailRate) {
        this.retailRate = retailRate;
    }

    public String getRetailFee() {
        return retailFee;
    }

    public void setRetailFee(String retailFee) {
        this.retailFee = retailFee;
    }

    public String getRetailFeeCurrency() {
        return retailFeeCurrency;
    }

    public void setRetailFeeCurrency(String retailFeeCurrency) {
        this.retailFeeCurrency = retailFeeCurrency;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public String getPurposeOfRemittance() {
        return purposeOfRemittance;
    }

    public void setPurposeOfRemittance(String purposeOfRemittance) {
        this.purposeOfRemittance = purposeOfRemittance;
    }

    public String getDocumentReferenceNumber() {
        return documentReferenceNumber;
    }

    public void setDocumentReferenceNumber(String documentReferenceNumber) {
        this.documentReferenceNumber = documentReferenceNumber;
    }
}
