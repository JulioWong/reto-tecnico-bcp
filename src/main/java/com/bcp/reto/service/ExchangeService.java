package com.bcp.reto.service;

import com.bcp.reto.entity.Exchange;
import com.bcp.reto.servicedto.request.CalculateExchangeRateRequest;
import com.bcp.reto.servicedto.request.SaveExchangeRateRequest;
import com.bcp.reto.servicedto.response.CalculateExchangeRateResponse;

import io.reactivex.Single;

public interface ExchangeService {
	
	public Single<CalculateExchangeRateResponse> calculateExchangeRate(CalculateExchangeRateRequest requestExchangeRate);
	
	public Exchange saveExchangeRate(SaveExchangeRateRequest saveExchangeRateRequest);
}
