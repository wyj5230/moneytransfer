package com.moneytransfer.webapi.service.impl;

import com.moneytransfer.webapi.dto.SendEmail;
import com.moneytransfer.webapi.dto.response.TransactionResponse;
import com.moneytransfer.webapi.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmailServiceImpl implements EmailService {

    @Value("${thunes.emailsender}")
    private String senderAddress;
    @Value("${thunes.emailsecret}")
    private String senderSecret;

    @Override
    public void deliverEmail(String recipient, String subject, String content) throws UnsupportedEncodingException, MessagingException {
        Map<String,String> map= new HashMap<String,String>();
        SendEmail mail = new SendEmail(senderAddress,senderSecret);
        map.put("mail.smtp.host", "smtp.qq.com");

        map.put("mail.smtp.auth", "true");
        map.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        map.put("mail.smtp.port", "465");
        map.put("mail.smtp.socketFactory.port", "465");
        mail.setPros(map);
        mail.initMessage();
        mail.setRecipient(recipient);
        mail.setSubject(subject);
        mail.setDate(new Date());
        mail.setFrom("MY");
        mail.setContent(content, "text/html; charset=UTF-8");

        System.out.println(mail.sendMessage());
    }

    @Override
    public void sendTransactionStatusUpdateEmail(TransactionResponse transactionResponse) throws UnsupportedEncodingException, MessagingException{
        System.out.println("sending email for transaction:" + transactionResponse.getId());
        String subject = "Transaction update :" + transactionResponse.getId();
        String content = "Status for transaction id:" + transactionResponse.getId() + " is updated to " + transactionResponse.getStatusMessage();
        this.deliverEmail(transactionResponse.getSender().getEmail(), subject, content);
    }
}
