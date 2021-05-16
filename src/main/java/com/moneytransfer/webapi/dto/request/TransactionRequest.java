package com.moneytransfer.webapi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moneytransfer.webapi.dto.*;

public class TransactionRequest {

    @JsonProperty("credit_party_identifier")
    private CreditPartyIdentifier creditPartyIdentifier;

    @JsonProperty("sender")
    private Sender sender;

    @JsonProperty("beneficiary")
    private Beneficiary beneficiary;

    @JsonProperty("external_id")
    private String external_id;

    @JsonProperty("retail_fee")
    private String retail_fee;

    @JsonProperty("retail_fee_currency")
    private String retail_fee_currency;

    @JsonProperty("purpose_of_remittance")
    private String purpose_of_remittance;

    @JsonProperty("document_reference_number")
    private String document_reference_number;

    public TransactionRequest() {
    }

    public TransactionRequest(CreditPartyIdentifier creditPartyIdentifier, Sender sender, Beneficiary beneficiary, String external_id, String retail_fee, String retail_fee_currency, String purpose_of_remittance, String document_reference_number) {
        this.creditPartyIdentifier = creditPartyIdentifier;
        this.sender = sender;
        this.beneficiary = beneficiary;
        this.external_id = external_id;
        this.retail_fee = retail_fee;
        this.retail_fee_currency = retail_fee_currency;
        this.purpose_of_remittance = purpose_of_remittance;
        this.document_reference_number = document_reference_number;
    }

    public CreditPartyIdentifier getCreditPartyIdentifier() {
        return creditPartyIdentifier;
    }

    public void setCreditPartyIdentifier(CreditPartyIdentifier creditPartyIdentifier) {
        this.creditPartyIdentifier = creditPartyIdentifier;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getRetail_fee() {
        return retail_fee;
    }

    public void setRetail_fee(String retail_fee) {
        this.retail_fee = retail_fee;
    }

    public String getRetail_fee_currency() {
        return retail_fee_currency;
    }

    public void setRetail_fee_currency(String retail_fee_currency) {
        this.retail_fee_currency = retail_fee_currency;
    }

    public String getPurpose_of_remittance() {
        return purpose_of_remittance;
    }

    public void setPurpose_of_remittance(String purpose_of_remittance) {
        this.purpose_of_remittance = purpose_of_remittance;
    }

    public String getDocument_reference_number() {
        return document_reference_number;
    }

    public void setDocument_reference_number(String document_reference_number) {
        this.document_reference_number = document_reference_number;
    }
}
