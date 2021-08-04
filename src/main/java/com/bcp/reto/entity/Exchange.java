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
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long exchange_rate_id;
	
	@Column(name="local_currency")
	private String localCurrency;
	
	@Column(name="foreign_currency")
	private String foreignCurrency;
	
	@Column(name="conversion_factor")
	private double conversionFactor;

	public Long getExchange_rate_id() {
		return exchange_rate_id;
	}

	public void setExchange_rate_id(Long exchange_rate_id) {
		this.exchange_rate_id = exchange_rate_id;
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
