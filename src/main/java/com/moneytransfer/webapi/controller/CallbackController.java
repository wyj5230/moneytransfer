package com.moneytransfer.webapi.controller;

import com.moneytransfer.webapi.dto.response.TransactionResponse;
import com.moneytransfer.webapi.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moneytransfer")
public class CallbackController {

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping("/callback")
    void transactionCallback(@RequestBody TransactionResponse transaction) {
        try {
            emailService.sendTransactionStatusUpdateEmail(transaction);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
