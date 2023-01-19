package com.intro.microservices.currencyexchangeservice.controller;

import com.intro.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.intro.microservices.currencyexchangeservice.configuration.Configuration;
import com.intro.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from,@PathVariable String to){
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);
        if(currencyExchange == null) throw new IllegalArgumentException("Taux de change non trouvé pour "+from+" -> "+to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironnement(port);
        System.err.println("CurrencyExchangeController  "+currencyExchange.getEnvironnement());
        return currencyExchange;
    }
}
