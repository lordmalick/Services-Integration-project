package com.intro.microservices.currencyexchangeservice.controller;

import com.intro.microservices.currencyexchangeservice.bean.CurrencyConversion;
import com.intro.microservices.currencyexchangeservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {
    private static final String FEIGN_REST_CLIENT ="Feign Rest Client";
    private static final String REST_TEMPLATE = "Rest Template";
    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;
    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversion getCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal amount){
        CurrencyConversion currencyConversion = currencyExchangeProxy.getCurrencyExchange(from, to);
        currencyConversion.setSource(FEIGN_REST_CLIENT);
        System.err.println(currencyConversion.getEnvironnement());
        return new CurrencyConversion(currencyConversion.getId(),
           from,to,
                amount,currencyConversion.getRateExchange(),
                amount.multiply(currencyConversion.getRateExchange()),currencyConversion.getSource(),currencyConversion.getEnvironnement());
    }

    @GetMapping("/currency-conversion/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversion getCurrencyExchange(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal amount){

        HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversion>responseEntity =
                new RestTemplate().
                        getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
        CurrencyConversion currencyConversion =  responseEntity.getBody();
        currencyConversion.setSource(REST_TEMPLATE);


        return new CurrencyConversion(currencyConversion.getId(),
                currencyConversion.getFrom(),currencyConversion.getTo(),
                currencyConversion.getAmount(),currencyConversion.getRateExchange(),
                amount.multiply(currencyConversion.getRateExchange()),currencyConversion.getSource(),currencyConversion.getEnvironnement());
    }
}
