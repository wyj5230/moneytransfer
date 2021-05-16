package com.moneytransfer.webapi.service;

import com.moneytransfer.webapi.dto.request.QuotationRequest;
import com.moneytransfer.webapi.dto.request.TransactionRequest;
import com.moneytransfer.webapi.dto.response.QuotationResponse;
import com.moneytransfer.webapi.dto.response.TransactionResponse;
import org.springframework.http.ResponseEntity;

public interface MoneyTransferRestfulApiClientService {

    ResponseEntity<QuotationResponse> postQuotation(QuotationRequest quotationRequest);
    ResponseEntity<TransactionResponse> postTransaction(String quotationId, TransactionRequest transactionRequest);
    ResponseEntity<TransactionResponse> confirmTransaction(String transactionId);
    ResponseEntity<TransactionResponse> getTransaction(String transactionId);
}
