package com.bcp.reto.service;

import java.util.ArrayList;

import com.bcp.reto.entity.Exchange;
import com.bcp.reto.servicedto.request.CalculateExchangeRateRequest;
import com.bcp.reto.servicedto.request.SaveExchangeRateRequest;
import com.bcp.reto.servicedto.response.CalculateExchangeRateResponse;

import io.reactivex.Single;

public interface ExchangeService {
	
	public Single<CalculateExchangeRateResponse> calculateExchangeRate(CalculateExchangeRateRequest requestExchangeRate);
	
	public ArrayList<Exchange> saveExchangeRate(ArrayList<SaveExchangeRateRequest> saveExchangeRateRequest);
}
