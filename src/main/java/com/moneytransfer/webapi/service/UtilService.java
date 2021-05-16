package com.moneytransfer.webapi.service;

public class UtilService {
    static public String generateExternalId(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<= 10; i++){
            result.append((int)(Math.random() * 10));
        }
        return result.toString();
    }
}
