package com.moneytransfer.webapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditPartyIdentifier {

    @JsonProperty("msisdn")
    private String msisdn;

    @JsonProperty("bank_account_number")
    private String bankAccountNumber;

    @JsonProperty("swift_bic_code")
    private String swiftBicCode;

    public CreditPartyIdentifier() {
    }

    public CreditPartyIdentifier(String msisdn, String bankAccountNumber, String swiftBicCode) {
        this.msisdn = msisdn;
        this.bankAccountNumber = bankAccountNumber;
        this.swiftBicCode = swiftBicCode;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getSwiftBicCode() {
        return swiftBicCode;
    }

    public void setSwiftBicCode(String swiftBicCode) {
        this.swiftBicCode = swiftBicCode;
    }
}
