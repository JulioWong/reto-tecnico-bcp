package com.bcp.reto.service;
import com.bcp.reto.servicedto.request.CalculateExchangeRateRequest;
import com.bcp.reto.servicedto.request.SaveExchangeRateRequest;
import com.bcp.reto.servicedto.response.CalculateExchangeRateResponse;

import java.text.DecimalFormat;

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
	private ExchangeRepository exchangeDAO;

	@Override
	@Transactional(readOnly = true)
	public Single<CalculateExchangeRateResponse> calculateExchangeRate(CalculateExchangeRateRequest requestExchangeRate) {
		return Single.create(singleSubscriber -> {
			Exchange data = exchangeDAO.findByLocalCurrencyAndForeignCurrency(
				requestExchangeRate.getMonedaOrigen(), 
				requestExchangeRate.getMonedaDestino()
			);
						
			if (data != null) {
				Double monto = requestExchangeRate.getMonto() / data.getConversionFactor();
				DecimalFormat numberFormat = new DecimalFormat("#,##0.00");
				CalculateExchangeRateResponse response = new CalculateExchangeRateResponse(
					numberFormat.format(monto), 
					data.getConversionFactor(), 
					requestExchangeRate.getMonedaOrigen(), 
					requestExchangeRate.getMonedaDestino()
				);
				
				singleSubscriber.onSuccess(response);
			} else {
				singleSubscriber.onError(new EntityNotFoundException());
			}
		});
	}

	@Override
	@Transactional
	public Exchange saveExchangeRate(SaveExchangeRateRequest saveExchangeRateRequest) {
		Exchange exchange = new Exchange();
		exchange.setLocalCurrency(saveExchangeRateRequest.getMonedaOrigen());
		exchange.setForeignCurrency(saveExchangeRateRequest.getMonedaDestino());
		exchange.setConversionFactor(saveExchangeRateRequest.getTipoCambio());
		return exchangeDAO.save(exchange);
	}
}
