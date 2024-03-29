package com.bcp.reto.servicedto.response;

import java.io.Serializable;

public class CalculateExchangeRateResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private double monto;
	private String monto_con_tipo_cambio_v3;
	private double tipo_cambio;
	private String moneda_origen;
	private String moneda_destino;
	
	public CalculateExchangeRateResponse(double monto, String monto_con_tipo_cambio, double tipo_cambio, String moneda_origen,
			String moneda_destino) {
		super();
		this.monto = monto;
		this.monto_con_tipo_cambio_v3 = monto_con_tipo_cambio;
		this.tipo_cambio = tipo_cambio;
		this.moneda_origen = moneda_origen;
		this.moneda_destino = moneda_destino;
	}

	public double getMonto() {
		return monto;
	}
	
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	public String getMonto_con_tipo_cambio_v3() {
		return monto_con_tipo_cambio_v3;
	}

	public void setMonto_con_tipo_cambio_v3(String monto_con_tipo_cambio) {
		this.monto_con_tipo_cambio_v3 = monto_con_tipo_cambio;
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
