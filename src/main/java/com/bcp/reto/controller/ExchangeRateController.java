package com.bcp.reto.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcp.reto.entity.Exchange;
import com.bcp.reto.service.ExchangeService;
import com.bcp.reto.servicedto.request.CalculateExchangeRateRequest;
import com.bcp.reto.servicedto.request.SaveExchangeRateRequest;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Controller
@RequestMapping("/api/exchange_rate")
public class ExchangeRateController {

	@Autowired
	private ExchangeService exchangeService;
	
	@PostMapping(
		path="/calc", 
		consumes = MediaType.APPLICATION_JSON_VALUE, 
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Single<ResponseEntity<?>> calculateExchangeRate(@Valid @RequestBody CalculateExchangeRateRequest requestExchangeRate) {
		return exchangeService.calculateExchangeRate(requestExchangeRate).subscribeOn(Schedulers.io()).map(s -> ResponseEntity.ok().body(s));
	}
	
	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE, 
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<?> save(@Valid @RequestBody ArrayList<SaveExchangeRateRequest> exchangeRateRequest) {
		ArrayList<Exchange> e = exchangeService.saveExchangeRate(exchangeRateRequest);
		return new ResponseEntity<>(e, HttpStatus.CREATED);
	}
}













