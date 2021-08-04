package com.bcp.reto.repository;

import org.springframework.data.repository.CrudRepository;

import com.bcp.reto.entity.Exchange;

public interface ExchangeRepository extends CrudRepository<Exchange, Long> {
	
	public Exchange findByLocalCurrencyAndForeignCurrency(String localCurrency, String foreignCurrency);
}
