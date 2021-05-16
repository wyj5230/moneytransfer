package com.moneytransfer.webapi.service;

import com.moneytransfer.webapi.dto.response.TransactionResponse;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

public interface EmailService {
    void deliverEmail(String recipient, String subject, String content) throws UnsupportedEncodingException, MessagingException;
    void sendTransactionStatusUpdateEmail(TransactionResponse transactionResponse) throws UnsupportedEncodingException, MessagingException;
}
