package com.moneytransfer.webapi;

import com.moneytransfer.webapi.dto.*;
import com.moneytransfer.webapi.dto.request.QuotationRequest;
import com.moneytransfer.webapi.dto.request.TransactionRequest;
import com.moneytransfer.webapi.dto.response.QuotationResponse;
import com.moneytransfer.webapi.dto.response.TransactionResponse;
import com.moneytransfer.webapi.service.UtilService;
import com.moneytransfer.webapi.service.impl.EmailServiceImpl;
import com.moneytransfer.webapi.service.impl.MoneyTransferRestfulApiClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class WebapiApplicationTests {

    //For quotations
    private final String PAYER_ID = "83";
    private final String MODE = "SOURCE_AMOUNT";
    private final String TRANSACTION_TYPE = "C2C";
    private final String AMOUNT_10 = "10";
    private final String CURRENCY_SGD = "SGD";
    private final String COUNTRY_ISO_CODE_SGP = "SGP";
    private final String CURRENCY_PHP = "PHP";

    //For transactions
    private final String CREDIT_PARTY_MSISDN_100 = "263775892100";
    private final String CREDIT_PARTY_MSISDN_117 = "263775892117";
    private final String CREDIT_PARTY_MSISDN_104 = "263775892104";
    private final String CREDIT_PARTY_MSISDN_111 = "263775892111";
    private final String BANK_ACCOUNT_NUMBER = "0123456789";
    private final String SWIFT_BIC_CODE = "ABCDEFGH";
    private final String LASTNAME_DOE = "Doe";
    private final String FIRSTNAME_JOHN = "John";
    private final String FIRSTNAME_JANE = "John";
    private final String DATE_OF_BIRTH = "1970-01-01";
    private final String ISO_CODE_SGP = "SGP";
    private final String GENDER = "MALE";
    private final String ADDRESS = "42 Rue des fleurs";
    private final String POSTAL_CODE = "75000";
    private final String CITY = "Paris";
    private final String ISO_CODE_FRA = "FRA";
    private final String SENDER_MSISDN = "33712345678";
    private final String BENEFICIARY_MSISDN = "263775892364";
    private final String EMAIL = "327113606@qq.com";
    private final String ID_TYPE = "SOCIAL_SECURITY";
    private final String ID_NUMBER_JOHN = "502-42-0158";
    private final String ID_NUMBER_JANE = "178027317681327";
    private final String ID_DELIVERY_DATE = "2016-01-01";
    private final String OCCUPATION_JOHN = "Residential Advisor";
    private final String OCCUPATION_JANE = "Sales Executive";
    private final String RETAIL_FEE = "Sales Executive";
    private final String RETAIL_FEE_CURRENCY = "Sales Executive";


    @Autowired
    private MoneyTransferRestfulApiClientServiceImpl moneyTransferRestfulApiClientService;

    @Autowired
    private EmailServiceImpl emailService;


    @Test
    void testSuccessFlow() throws InterruptedException {
        QuotationResponse quotationResponse = testQuotation();
        TransactionResponse transactionResponse = testCreateTransaction(quotationResponse.getId(), CREDIT_PARTY_MSISDN_100);
        testConfirmTransaction(transactionResponse.getId());
        Thread.sleep(3000);
        testGetTransaction(transactionResponse.getId());
    }

    @Test
    void testPayerUnavailableFlow() throws InterruptedException{
        QuotationResponse quotationResponse = testQuotation();
        TransactionResponse transactionResponse = testCreateTransaction(quotationResponse.getId(), CREDIT_PARTY_MSISDN_117);
        testConfirmTransaction(transactionResponse.getId());
        Thread.sleep(3000);
        testGetTransaction(transactionResponse.getId());
    }

    @Test
    void testBarredBeneficiaryFlow() throws InterruptedException{
        QuotationResponse quotationResponse = testQuotation();
        TransactionResponse transactionResponse = testCreateTransaction(quotationResponse.getId(), CREDIT_PARTY_MSISDN_104);
        testConfirmTransaction(transactionResponse.getId());
        Thread.sleep(3000);
        testGetTransaction(transactionResponse.getId());
    }

    @Test
    void testLimitationOnTransactionFlow() throws InterruptedException{
        QuotationResponse quotationResponse = testQuotation();
        TransactionResponse transactionResponse = testCreateTransaction(quotationResponse.getId(), CREDIT_PARTY_MSISDN_111);
        testConfirmTransaction(transactionResponse.getId());
        Thread.sleep(3000);
        testGetTransaction(transactionResponse.getId());
    }

    private QuotationResponse testQuotation() {
        QuotationRequest quotationRequest = getQuotationRequest();
        QuotationResponse quotationResponse = moneyTransferRestfulApiClientService.postQuotation(quotationRequest).getBody();
        System.out.println(">>>>>>>>>>Quotation Created:" + quotationResponse.getId());
        System.out.println(">>>>>>>>>>Quotation Payer:" + quotationResponse.getPayer().toString());
        System.out.println(">>>>>>>>>>Quotation Fee:" + quotationResponse.getFee().toString());
        return quotationResponse;
    }

    private QuotationRequest getQuotationRequest() {
        QuotationRequest quotationRequest = new QuotationRequest();
        String externalId = UtilService.generateExternalId();
        quotationRequest.setExternalId(externalId);
        quotationRequest.setPayerId(PAYER_ID);
        quotationRequest.setMode(MODE);
        quotationRequest.setTransactionType(TRANSACTION_TYPE);
        Source source = new Source(AMOUNT_10, CURRENCY_SGD, COUNTRY_ISO_CODE_SGP);
        quotationRequest.setSource(source);
        Destination destination = new Destination(null, CURRENCY_PHP);
        quotationRequest.setDestination(destination);
        return quotationRequest;
    }

    private TransactionResponse testCreateTransaction(String quotationId, String creditPartyMsisdn) {
        TransactionRequest transactionRequest = getTransactionRequest(creditPartyMsisdn);
        TransactionResponse transactionResponse = moneyTransferRestfulApiClientService.postTransaction(quotationId,
                transactionRequest).getBody();
        System.out.println(">>>>>>>>>>Transactiong Created:" + transactionResponse.getId());
        sendEmail(transactionResponse);
        return transactionResponse;
    }

    private TransactionRequest getTransactionRequest(String creditPartyMsisdn) {
        TransactionRequest transactionRequest = new TransactionRequest();
        CreditPartyIdentifier creditPartyIdentifier = new CreditPartyIdentifier(creditPartyMsisdn, BANK_ACCOUNT_NUMBER, SWIFT_BIC_CODE);
        Sender sender = new Sender(LASTNAME_DOE, FIRSTNAME_JOHN, ISO_CODE_SGP, DATE_OF_BIRTH,
                ISO_CODE_SGP, GENDER, ADDRESS, POSTAL_CODE, CITY, ISO_CODE_SGP,
                SENDER_MSISDN, EMAIL, ID_TYPE, ID_NUMBER_JOHN, ID_DELIVERY_DATE, OCCUPATION_JOHN);
        Beneficiary beneficiary = new Beneficiary(LASTNAME_DOE, FIRSTNAME_JANE, ISO_CODE_FRA, DATE_OF_BIRTH,
                ISO_CODE_FRA, GENDER, ADDRESS, POSTAL_CODE, CITY, ISO_CODE_FRA,
                SENDER_MSISDN, EMAIL, ID_TYPE, ISO_CODE_FRA, ID_NUMBER_JANE, OCCUPATION_JANE);
        transactionRequest.setCreditPartyIdentifier(creditPartyIdentifier);
        transactionRequest.setSender(sender);
        transactionRequest.setBeneficiary(beneficiary);
        transactionRequest.setExternal_id(UtilService.generateExternalId());
        return transactionRequest;
    }

    private TransactionResponse testConfirmTransaction(String transactionId) {
        TransactionResponse transactionResponse = moneyTransferRestfulApiClientService.confirmTransaction(transactionId).getBody();
        System.out.println(">>>>>>>>>>Transactiong Confirmed:" + transactionResponse.getId());
        System.out.println(">>>>>>>>>>Transactiong Status:" + transactionResponse.getStatusMessage());
        sendEmail(transactionResponse);
        return transactionResponse;
    }

    private void testGetTransaction(String transactionId) {
        TransactionResponse transactionResponse = moneyTransferRestfulApiClientService.getTransaction(transactionId).getBody();
        System.out.println(">>>>>>>>>>Retrieving transactiong id:" + transactionResponse.getId());
        System.out.println(">>>>>>>>>>Transactiong Status:" + transactionResponse.getStatusMessage());
    }

    private void sendEmail(TransactionResponse transactionResponse) {
        try {
            emailService.sendTransactionStatusUpdateEmail(transactionResponse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




}
