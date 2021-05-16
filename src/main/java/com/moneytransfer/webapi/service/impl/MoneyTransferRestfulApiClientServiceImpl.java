package com.moneytransfer.webapi.service.impl;

import com.moneytransfer.webapi.dto.request.QuotationRequest;
import com.moneytransfer.webapi.dto.request.TransactionRequest;
import com.moneytransfer.webapi.dto.response.QuotationResponse;
import com.moneytransfer.webapi.dto.response.TransactionResponse;
import com.moneytransfer.webapi.service.MoneyTransferRestfulApiClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class MoneyTransferRestfulApiClientServiceImpl implements MoneyTransferRestfulApiClientService {

    private static final Logger log = LoggerFactory.getLogger(MoneyTransferRestfulApiClientServiceImpl.class);

    @Value("${thunes.baseUrl}")
    private String baseUrl;
    @Value("${thunes.quotations}")
    private String quotationsUrl;
    @Value("${thunes.transactions}")
    private String transactionsUrl;
    @Value("${thunes.confirm}")
    private String confirmUrl;

    @Autowired
    @Qualifier("MoneyTransferRestTemplate")
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<QuotationResponse> postQuotation(QuotationRequest quotationRequest) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl).pathSegment(quotationsUrl);
        ResponseEntity<QuotationResponse> quotationResponseResponseEntity = restTemplate.exchange(
                uriComponentsBuilder.build().toUri(), HttpMethod.POST, new HttpEntity<>(quotationRequest), new ParameterizedTypeReference<QuotationResponse>() {
                });
        //log.info("API call to create quotation return status of {}", quotationResponseResponseEntity.getStatusCode());
        return quotationResponseResponseEntity;
    }

    @Override
    public ResponseEntity<TransactionResponse> postTransaction(String quotationId, TransactionRequest transactionRequest) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .pathSegment(quotationsUrl).pathSegment(quotationId).pathSegment(transactionsUrl);
        ResponseEntity<TransactionResponse> transactionResponseResponseEntity = restTemplate.exchange(
                uriComponentsBuilder.build().toUri(), HttpMethod.POST, new HttpEntity<>(transactionRequest), new ParameterizedTypeReference<TransactionResponse>() {
                });
        //log.info("API call to create quotation return status of {}", transactionResponseResponseEntity.getStatusCode());
        return transactionResponseResponseEntity;
    }

    @Override
    public ResponseEntity<TransactionResponse> confirmTransaction(String transactionId) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .pathSegment(transactionsUrl).pathSegment(transactionId).pathSegment(confirmUrl);
        ResponseEntity<TransactionResponse> transactionResponseResponseEntity = restTemplate.exchange(
                uriComponentsBuilder.build().toUri(), HttpMethod.POST, null, new ParameterizedTypeReference<TransactionResponse>() {
                });
        //log.info("API call to create quotation return status of {}", transactionResponseResponseEntity.getStatusCode());
        return transactionResponseResponseEntity;
    }

    @Override
    public ResponseEntity<TransactionResponse> getTransaction(String transactionId) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .pathSegment(transactionsUrl).pathSegment(transactionId);
        ResponseEntity<TransactionResponse> transactionResponseResponseEntity = restTemplate.exchange(
                uriComponentsBuilder.build().toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<TransactionResponse>() {
                });
        //log.info("Transaction {} status is {}", transactionId, transactionResponseResponseEntity.getBody().getStatusMessage());
        return transactionResponseResponseEntity;
    }

}
