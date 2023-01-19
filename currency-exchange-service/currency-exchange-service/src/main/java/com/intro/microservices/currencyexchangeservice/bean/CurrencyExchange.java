package com.intro.microservices.currencyexchangeservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {
	@Id
	private long id ;
	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to ;
	private BigDecimal rateExchange;
	private String environnement;
	
	public CurrencyExchange  () {}

	public CurrencyExchange(long id, String from, String to, BigDecimal rateExchange,String environnement) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.rateExchange = rateExchange;
		this.environnement=environnement;
	}

	public String getEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(String environnement) {
		this.environnement = environnement;
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
