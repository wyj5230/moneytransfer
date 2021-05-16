package com.moneytransfer.webapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class MoneyTransferApiClientAutoConfig {

    @Value("${thunes.connectionTimeout:#{1000}}")
    private long connectionTimeout;

    @Value("${webapi.apiKey}")
    String API_KEY;

    @Value("${webapi.apiSecret}")
    String API_SECRET;

    public MoneyTransferApiClientAutoConfig() {
    }

    @Bean(name={"MoneyTransferRestTemplate"})
    RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder().basicAuthentication(API_KEY, API_SECRET);
        return restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(this.connectionTimeout)).build();
    }
}
