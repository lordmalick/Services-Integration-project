package com.intro.microservices.currencyexchangeservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ConfigurationProperties("currency-exchange-service")
public class Configuration {

    private long id ;
    private String from;
    private String to ;
    private BigDecimal rateExchange;

    public Configuration() {}

    public Configuration(long id, String from, String to, BigDecimal rateExchange) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.rateExchange = rateExchange;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getRateExchange() {
        return rateExchange;
    }

    public void setRateExchange(BigDecimal rateExchange) {
        this.rateExchange = rateExchange;
    }
}
