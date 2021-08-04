package com.bcp.reto.servicedto.response;

import java.io.Serializable;

public class CalculateExchangeRateResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String monto;
	private double tipo_cambio;
	private String moneda_origen;
	private String moneda_destino;
	
	public CalculateExchangeRateResponse(String monto, double tipo_cambio, String moneda_origen,
			String moneda_destino) {
		super();
		this.monto = monto;
		this.tipo_cambio = tipo_cambio;
		this.moneda_origen = moneda_origen;
		this.moneda_destino = moneda_destino;
	}

	public String getMonto() {
		return monto;
	}
	
	public void setMonto(String monto) {
		this.monto = monto;
	}
	
	public double getTipo_cambio() {
		return tipo_cambio;
	}
	
	public void setTipo_cambio(double tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}
	
	public String getMoneda_origen() {
		return moneda_origen;
	}
	
	public void setMoneda_origen(String moneda_origen) {
		this.moneda_origen = moneda_origen;
	}
	
	public String getMoneda_destino() {
		return moneda_destino;
	}
	
	public void setMoneda_destino(String moneda_destino) {
		this.moneda_destino = moneda_destino;
	}
}
