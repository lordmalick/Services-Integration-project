package com.intro.microservices.currencyexchangeservice.controller;

import com.intro.microservices.currencyexchangeservice.bean.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversion getCurrencyExchange(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal amount){

        HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversion>responseEntity =
                new RestTemplate().
                        getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
        CurrencyConversion currencyConversion =  responseEntity.getBody();


        return new CurrencyConversion(currencyConversion.getId(),
                currencyConversion.getFrom(),currencyConversion.getTo(),
                currencyConversion.getAmount(),currencyConversion.getRateExchange(),
                amount.multiply(currencyConversion.getRateExchange()));
    }
}
