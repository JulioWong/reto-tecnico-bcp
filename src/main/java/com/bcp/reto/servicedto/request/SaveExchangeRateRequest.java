package com.bcp.reto.servicedto.request;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SaveExchangeRateRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Size(min = 2, max = 5, message = "Moneda de origen debe tener minimo 2 caracteres")
	@Pattern(regexp="^[A-Za-z]*$",message = "Moneda de origen solo debe contener texto")
	private String moneda_origen;

	@Size(min = 2, max = 5, message = "Moneda destino debe tener minimo 2 caracteres")
	@Pattern(regexp="^[A-Za-z]*$",message = "Moneda destino solo debe contener texto")
	private String moneda_destino;
	
	@Min(1)
	private double tipo_cambio;

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

	public double getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(double tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}
}
