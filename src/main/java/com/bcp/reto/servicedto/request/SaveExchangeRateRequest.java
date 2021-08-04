package com.bcp.reto.servicedto.request;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SaveExchangeRateRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Size(min = 2, max = 5, message = "Moneda de origen debe tener minimo 2 caracteres")
	@Pattern(regexp="^[A-Za-z]*$",message = "Moneda de origen solo debe contener texto")
	private String monedaOrigen;

	@Size(min = 2, max = 5, message = "Moneda destino debe tener minimo 2 caracteres")
	@Pattern(regexp="^[A-Za-z]*$",message = "Moneda destino solo debe contener texto")
	private String monedaDestino;
	
	@Min(1)
	private double tipoCambio;

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
}
