package com.bcp.reto.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bcp.reto.entity.Exchange;
import com.bcp.reto.repository.ExchangeRepository;
import com.bcp.reto.servicedto.request.CalculateExchangeRateRequest;
import com.bcp.reto.servicedto.response.CalculateExchangeRateResponse;

import io.reactivex.observers.TestObserver;

@ExtendWith(MockitoExtension.class)
public class ExchangeServiceImplTest {
	
	@Mock
	private ExchangeRepository exchangeRepository;
	
	@InjectMocks
    private ExchangeServiceImpl exchangeService;

	@Test
    public void calculateExchangeRate_Success_ReturnSingleOfExchangeResponse() {
		
		Exchange exchange = new Exchange(1L, "PEN", "USD", 3.93);
		
		when(exchangeRepository.findByLocalCurrencyAndForeignCurrency(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(exchange);
		
		CalculateExchangeRateRequest calculateExchangeRateRequest = new CalculateExchangeRateRequest();
		calculateExchangeRateRequest.setMoneda_origen("PEN");
		calculateExchangeRateRequest.setMoneda_destino("USD");
		calculateExchangeRateRequest.setMonto(760);
		
		TestObserver<CalculateExchangeRateResponse> testObserver = exchangeService.calculateExchangeRate(calculateExchangeRateRequest).test();
		testObserver.awaitTerminalEvent();
		testObserver.assertValue(CalculateExchangeRateResponse -> CalculateExchangeRateResponse.getMonto_con_tipo_cambio_v3().equals("193.38"));
		verify(exchangeRepository, Mockito.times(1)).findByLocalCurrencyAndForeignCurrency(Mockito.anyString(), Mockito.anyString());
    }

}
