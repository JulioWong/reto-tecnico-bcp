package com.bcp.reto.service;
import com.bcp.reto.servicedto.request.CalculateExchangeRateRequest;
import com.bcp.reto.servicedto.request.SaveExchangeRateRequest;
import com.bcp.reto.servicedto.response.CalculateExchangeRateResponse;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcp.reto.entity.Exchange;
import com.bcp.reto.repository.ExchangeRepository;
import io.reactivex.Single;

@Service
public class ExchangeServiceImpl implements ExchangeService {

	@Autowired
	private ExchangeRepository exchangeRepository;

	@Override
	@Transactional(readOnly = true)
	public Single<CalculateExchangeRateResponse> calculateExchangeRate(CalculateExchangeRateRequest requestExchangeRate) {
		return Single.create(singleSubscriber -> {
			Exchange data = exchangeRepository.findByLocalCurrencyAndForeignCurrency(
				requestExchangeRate.getMoneda_origen(), 
				requestExchangeRate.getMoneda_destino()
			);

			if (data != null) {
				
				if (data.getConversionFactor() == 0) {
					throw new RuntimeException("El valor de tipo de cambio debe ser mayor a 0");
				}
				
				Double montoCambio = requestExchangeRate.getMonto() / data.getConversionFactor();
				DecimalFormat numberFormat = new DecimalFormat("#,##0.00");
				CalculateExchangeRateResponse response = new CalculateExchangeRateResponse(
					requestExchangeRate.getMonto(),
					numberFormat.format(montoCambio), 
					data.getConversionFactor(), 
					requestExchangeRate.getMoneda_origen(), 
					requestExchangeRate.getMoneda_destino()
				);
				
				singleSubscriber.onSuccess(response);
			} else {
				singleSubscriber.onError(new EntityNotFoundException());
			}
		});
	}

	@Override
	@Transactional
	public ArrayList<Exchange> saveExchangeRate(ArrayList<SaveExchangeRateRequest> saveExchangeRateRequest) {
		
		ArrayList<Exchange> listExchange = new ArrayList<Exchange>();
		
		for (SaveExchangeRateRequest exReq : saveExchangeRateRequest) {
			Exchange exchangeDB = exchangeRepository.findByLocalCurrencyAndForeignCurrency(
				exReq.getMoneda_origen(), 
				exReq.getMoneda_destino()
			);
			
			if (exchangeDB == null) {
				Exchange exchange = new Exchange();
				exchange.setLocalCurrency(exReq.getMoneda_origen());
				exchange.setForeignCurrency(exReq.getMoneda_destino());
				exchange.setConversionFactor(exReq.getTipo_cambio());
				listExchange.add(exchangeRepository.save(exchange));
			} else {
				exchangeDB.setConversionFactor(exReq.getTipo_cambio());
				listExchange.add(exchangeRepository.save(exchangeDB));
			}
		}
		
		return listExchange;
	}
}
