package com.bcp.reto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exchange_rate")
public class Exchange implements Serializable {
	
	public Exchange(Long exchangeRateId, String localCurrency, String foreignCurrency, double conversionFactor) {
		super();
		this.exchangeRateId = exchangeRateId;
		this.localCurrency = localCurrency;
		this.foreignCurrency = foreignCurrency;
		this.conversionFactor = conversionFactor;
	}
	
	public Exchange() {
		super();
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long exchangeRateId;
	
	@Column(name="local_currency")
	private String localCurrency;
	
	@Column(name="foreign_currency")
	private String foreignCurrency;
	
	@Column(name="conversion_factor")
	private double conversionFactor;

	public Long getExchangeRateId() {
		return exchangeRateId;
	}

	public void setExchangeRateId(Long exchangeRateId) {
		this.exchangeRateId = exchangeRateId;
	}

	public String getLocalCurrency() {
		return localCurrency;
	}

	public void setLocalCurrency(String localCurrency) {
		this.localCurrency = localCurrency;
	}

	public String getForeignCurrency() {
		return foreignCurrency;
	}

	public void setForeignCurrency(String foreignCurrency) {
		this.foreignCurrency = foreignCurrency;
	}

	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
}
